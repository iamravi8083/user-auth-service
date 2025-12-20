package com.ravi.userauthservice.user.service;

import com.ravi.userauthservice.user.entity.User;

public interface UserService {

    User registerUser(User user);

    User getUserByEmail(String email);
}
