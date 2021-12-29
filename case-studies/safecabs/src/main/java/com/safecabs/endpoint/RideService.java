package com.safecabs.endpoint;

import com.safecabs.model.RideRequest;

public interface RideService {

    String requestRide(RideRequest rideRequest);

    void shutDown();

}
