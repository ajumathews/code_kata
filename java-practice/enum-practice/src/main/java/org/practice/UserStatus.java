package org.practice;

public enum UserStatus {
    PENDING,
    ACTIVE,
    INACTIVE,
    DELETED

}

class MainClass {
    public static void main(String[] args) {
        System.out.println(UserStatus.ACTIVE);
        for(UserStatus userStatus:UserStatus.values()){
            System.out.println(userStatus);
        }
    }
}

