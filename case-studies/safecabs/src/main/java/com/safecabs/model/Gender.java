package com.safecabs.model;

public enum Gender {
    MALE, FEMALE;

    public static Gender getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
