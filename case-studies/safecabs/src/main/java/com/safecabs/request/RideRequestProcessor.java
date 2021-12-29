package com.safecabs.request;

import com.safecabs.model.*;
import com.safecabs.mutex.RideMutex;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RideRequestProcessor implements Runnable {

    private RideMutex rideMutex;
    private RideRequest rideRequest;

    public RideRequestProcessor(RideRequest rideRequest, RideMutex rideMutex) {
        this.rideRequest = rideRequest;
        this.rideMutex = rideMutex;
    }

    @Override
    public void run() {
        User user = rideRequest.getUser();
        user.setUserStatus(UserStatus.PROCESSING_REQUEST);
        try {
            rideMutex.getLock().lock();
            Cab cab = findAvailableCabForTheUser(user);
            while (cab == null) {
                rideMutex.getIsCabAvailable().await();
                cab = findAvailableCabForTheUser(user);
            }

            bookCab(user, cab);
            //releasing the lock after the cab is booked
            rideMutex.getLock().unlock();

            //To Simulate Ride in Progress
            Thread.sleep(5000);

            //Ride ending
            rideMutex.getLock().lock();
            endRide(user, cab);
            rideMutex.getIsCabAvailable().signalAll();
            rideMutex.getLock().unlock();

        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        } finally {
            rideMutex.getLock().unlock();
        }
    }

    private void bookCab(User user, Cab cab) {
        cab.addPassenger(user);
        user.setCurrentCabId(cab.getCabId());
        user.setUserStatus(UserStatus.BOOKED_CAB);
        if (cab.getPassengers().size() < 4) {
            cab.setCabStatus(CabStatus.AWAITING_RIDERS);
        } else {
            cab.setCabStatus(CabStatus.RIDE_STARTED);
            user.setUserStatus(UserStatus.RIDE_STARTED);
        }
        logMessage(user, cab);
    }

    private void endRide(User user, Cab cab) {
        cab.setCabStatus(CabStatus.AVAILABLE);
        user.setUserStatus(UserStatus.RIDE_ENDED);
        cab.getRideHistory().put(System.currentTimeMillis() , cab.getPassengers());
        cab.getPassengers().clear();
        user.updateRideHistory(user.getCurrentCabId());
        user.setCurrentCabId(null);
        logMessage(user, cab);
    }

    private Cab findAvailableCabForTheUser(User user) {
        //Check if any existing cab waiting for riders is suitable for the user based on the gender
        Optional<Cab> optional = rideMutex.getCabs().stream().filter(c -> c.getCabStatus().equals(CabStatus.AWAITING_RIDERS)).findFirst();
        if (optional.isPresent()) {
            Cab cab = optional.get();
            if (checkIfTheNewRiderWillMakeItSafeJourney(cab, user)) {
                return cab;
            }
        }

        //Check for new available cabs
        optional = rideMutex.getCabs().stream().filter(c -> c.getCabStatus().equals(CabStatus.AVAILABLE)).findFirst();
        return optional.orElse(null);
    }

    private boolean checkIfTheNewRiderWillMakeItSafeJourney(Cab cab, User user) {
        List<User> users = cab.getPassengers();
        if (users.size() <= 2) {
            return true;
        }

        long numberOfMaleRiders = users.stream().filter(u -> u.getGender().equals(Gender.MALE)).count();
        long numberOfFemaleRiders = users.size() - numberOfMaleRiders;

        // this will take care of all male or all female
        if (numberOfFemaleRiders == 3 && user.getGender().equals(Gender.FEMALE)
                || numberOfMaleRiders == 3 && user.getGender().equals(Gender.MALE)) {
            return true;
        }

        //This check will make sure there are 2 male and 2 female combo
        if (numberOfMaleRiders == 2 && numberOfFemaleRiders == 1 && user.getGender().equals(Gender.FEMALE)
                || numberOfFemaleRiders == 2 && numberOfMaleRiders == 1 && user.getGender().equals(Gender.MALE)) {
            return true;
        }

        //rest all combo make an unsafe journey
        return false;
    }

    private void logMessage(User user, Cab cab) {
        if (!user.getUserStatus().equals(UserStatus.RIDE_ENDED)) {
            System.out.println("--");
            System.out.println(user.getName() + " " + user.getUserStatus() + " " + user.getCurrentCabId());
        }
        if (cab.getPassengers().size() != 0) {
            System.out.println("--");
            System.out.println(cab.getCabId() + " " + cab.getCabStatus() + " has passengers " + cab.getPassengers().stream().map(User::getName).collect(Collectors.joining(",")));
        }
    }

}
