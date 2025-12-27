package com.ravi.userauthservice.auth.service;

import com.ravi.userauthservice.exception.InvalidCredentialException;
import com.ravi.userauthservice.user.entity.User;
import com.ravi.userauthservice.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class AuthServiceImpl implements AuthService{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

   public AuthServiceImpl(UserService userService , PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User authenticate(String email, String password) {

       User user= userService.getUserByEmail(email);

       if(!passwordEncoder.matches(password,user.getPassword())){
           throw new InvalidCredentialException("invalid credential");
       }
        return user;
    }
}
