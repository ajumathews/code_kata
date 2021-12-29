package com.safecabs.endpoint.impl;

import com.safecabs.endpoint.RideService;
import com.safecabs.endpoint.UserService;
import com.safecabs.model.Cab;
import com.safecabs.model.RideRequest;
import com.safecabs.model.UserStatus;
import com.safecabs.mutex.RideMutex;
import com.safecabs.request.RideRequestHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RideServiceImpl implements RideService {

    private static RideService rideService;
    private UserService userService;
    private BlockingQueue<RideRequest> rideRequestQueue;
    private RideMutex rideMutex;
    private ExecutorService rideRequestHandlerExecutorService;

    private RideServiceImpl() {
        userService = UserServiceImpl.getInstance();
        rideRequestQueue = new ArrayBlockingQueue<>(1);
        rideMutex = initializeRideMutex();
        rideRequestHandlerExecutorService = Executors.newFixedThreadPool(1);
        rideRequestHandlerExecutorService.submit(new RideRequestHandler(rideRequestQueue, rideMutex));
    }

    private RideMutex initializeRideMutex() {
        List<Cab> cabs = initializeCabs();
        Lock lock = new ReentrantLock();
        Condition isCabAvailable = lock.newCondition();
        return new RideMutex(cabs, lock, isCabAvailable);
    }

    public String requestRide(RideRequest rideRequest) {
        if (!userService.validateUser(rideRequest.getUser())) {
            throw new RuntimeException(rideRequest.getUser().getName() + " not registered");
        }
        try {
            rideRequestQueue.put(rideRequest);
            rideRequest.getUser().setUserStatus(UserStatus.REQUEST_IN_QUEUE);
            System.out.println(rideRequest.getUser().getName() + "-" + rideRequest.getUser().getUserStatus());
            return rideRequest.getUser().getUserStatus().name();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
        return "Request Failed. Try Again";
    }

    /* To create a single instance of RideService*/
    public static synchronized RideService getInstance() {
        if (rideService == null) {
            rideService = new RideServiceImpl();
        }
        return rideService;
    }

    private List<Cab> initializeCabs() {
        List<Cab> cabs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cabs.add(new Cab("Cab-" + i));
        }
        return cabs;
    }

    public RideMutex getRideMutex() {
        return rideMutex;
    }

    public void shutDown() {
        RideRequestHandler.shutDownService = true;
        rideRequestHandlerExecutorService.shutdownNow();

    }
}
