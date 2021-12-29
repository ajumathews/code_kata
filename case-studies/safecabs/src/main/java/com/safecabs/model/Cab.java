package com.safecabs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cab{

    private String cabId;
    private List<User> passengers;
    private CabStatus cabStatus;
    private Map<Long, List<User>> rideHistory;

    public Cab(String cabId) {
        this.cabId = cabId;
        this.passengers = new ArrayList<>();
        this.cabStatus = CabStatus.AVAILABLE;
        this.rideHistory = new HashMap<>();
    }

    public List<User> getPassengers() {
        return passengers;
    }

    public void addPassenger(User user) {
        passengers.add(user);
    }

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public void setPassengers(List<User> passengers) {
        this.passengers = passengers;
    }

    public Map<Long, List<User>> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(Map<Long, List<User>> rideHistory) {
        this.rideHistory = rideHistory;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabId='" + cabId + '\'' +
                ", passengers=" + passengers +
                ", cabStatus=" + cabStatus +
                ", rideHistory=" + rideHistory +
                '}';
    }
}
