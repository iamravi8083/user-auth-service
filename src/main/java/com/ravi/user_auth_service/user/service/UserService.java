package com.ravi.user_auth_service.user.service;

import com.ravi.user_auth_service.user.entity.User;

public interface UserService {

    User registerUser(User user);

    User getUserByEmail(String email);
}
