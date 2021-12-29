package com.safecabs.model;

public class RideRequest {

    private User user;
    private String destination;

    public RideRequest(User user, String destination) {
        this.user = user;
        this.destination = destination;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
