package com.ravi.userauthservice.auth.service;

import com.ravi.userauthservice.user.entity.User;
import com.ravi.userauthservice.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
class AuthServiceImpl implements AuthService{
    private final UserService userService;

   public AuthServiceImpl(UserService userService){
        this.userService = userService;
    }

    @Override
    public User authenticate(String email, String password) {

       User user= userService.getUserByEmail(email);
       if(!user.getPassword().equals(password)){
           throw new RuntimeException("invalid credential");
       }
        return user;
    }
}
