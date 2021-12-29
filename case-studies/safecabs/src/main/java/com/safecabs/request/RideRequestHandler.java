package com.safecabs.request;

import com.safecabs.model.RideRequest;
import com.safecabs.model.UserStatus;
import com.safecabs.mutex.RideMutex;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RideRequestHandler implements Runnable {

    private BlockingQueue<RideRequest> rideRequestQueue;
    private RideMutex rideMutex;
    private ExecutorService rideRequestProcessorExecutorService;
    public static Boolean shutDownService = false;

    public RideRequestHandler(BlockingQueue<RideRequest> rideRequestQueue, RideMutex rideMutex) {
        this.rideRequestQueue = rideRequestQueue;
        this.rideRequestProcessorExecutorService = Executors.newFixedThreadPool(100);
        this.rideMutex = rideMutex;
    }

    @Override
    public void run() {
        while (!shutDownService) {
            try {
                RideRequest rideRequest = rideRequestQueue.take();
                rideRequest.getUser().setUserStatus(UserStatus.SUBMITTING_REQUEST_TO_PROCESS);
                rideRequestProcessorExecutorService.submit(new RideRequestProcessor(rideRequest, rideMutex));
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        rideRequestProcessorExecutorService.shutdownNow();
    }

}
