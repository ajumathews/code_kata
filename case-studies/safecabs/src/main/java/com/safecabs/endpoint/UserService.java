package com.safecabs.endpoint;

import com.safecabs.model.User;

public interface UserService {

    void registerUser(User user);

    Boolean validateUser(User user);

}
