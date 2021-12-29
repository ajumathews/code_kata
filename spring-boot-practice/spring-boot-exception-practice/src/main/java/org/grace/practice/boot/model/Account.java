package org.grace.practice.boot.model;

public class Account {

    private int accountId;

    public Account(int accountId) {
        this.accountId = accountId;
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }
}
