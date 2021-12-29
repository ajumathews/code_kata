package com.safecabs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String name;
    private String mobileNumber;
    private Gender gender;
    private UserStatus userStatus;
    private String currentCabId;
    private List<String> rideHistory;

    public User(String name, String mobileNumber, Gender gender) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.userStatus = UserStatus.IDLE;
        this.rideHistory = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                mobileNumber.equals(user.mobileNumber) &&
                gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNumber, gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCurrentCabId() {
        return currentCabId;
    }

    public void setCurrentCabId(String currentCabId) {
        this.currentCabId = currentCabId;
    }

    public void updateRideHistory(String currentCabId){
        rideHistory.add(currentCabId);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", gender=" + gender +
                ", userStatus=" + userStatus +
                ", currentCabId='" + currentCabId + '\'' +
                ", rideHistory=" + rideHistory +
                '}';
    }
}
