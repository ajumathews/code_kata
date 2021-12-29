package com.safecabs.mutex;

import com.safecabs.model.Cab;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class RideMutex {

    /*Shared Resource*/
    private List<Cab> cabs;

    private Lock lock;
    private Condition isCabAvailable;

    public RideMutex(List<Cab> cabs, Lock lock, Condition isCabAvailable) {
        this.cabs = cabs;
        this.lock = lock;
        this.isCabAvailable = isCabAvailable;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Condition getIsCabAvailable() {
        return isCabAvailable;
    }

    public void setIsCabAvailable(Condition isCabAvailable) {
        this.isCabAvailable = isCabAvailable;
    }

    public List<Cab> getCabs() {
        return cabs;
    }

    public void setCabs(List<Cab> cabs) {
        this.cabs = cabs;
    }
}
