package com.ravi.userauthservice.auth.service;

import com.ravi.userauthservice.user.entity.User;

public interface AuthService {

    User authenticate(String email , String password);
    String  login(String email, String password);
}
