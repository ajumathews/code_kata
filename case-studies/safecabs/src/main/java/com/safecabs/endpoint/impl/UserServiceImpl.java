package com.safecabs.endpoint.impl;

import com.safecabs.model.User;
import com.safecabs.endpoint.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private static UserService userService;
    private Map<String, User> users;

    private UserServiceImpl() {
        this.users = new HashMap<>();
    }

    public void registerUser(User user) {
        //We can put extra logic to validate user before adding to the Map
        users.put(user.getMobileNumber(), user);
    }

    public Boolean validateUser(User user) {
        if (user.equals(users.get(user.getMobileNumber()))) {
            return true;
        }
        return false;
    }

    /* To create a single instance of UserService*/
    public static synchronized UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }


}
