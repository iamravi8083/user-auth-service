package com.ravi.userauthservice.auth.service;

import com.ravi.userauthservice.exception.InvalidCredentialException;
import com.ravi.userauthservice.security.JwtUtil;
import com.ravi.userauthservice.user.entity.User;
import com.ravi.userauthservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class AuthServiceImpl implements AuthService{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public User authenticate(String email, String password) {

       User user= userService.getUserByEmail(email);

       if(!passwordEncoder.matches(password,user.getPassword())){
           throw new InvalidCredentialException("invalid credential");
       }
        return user;
    }

    @Override
    public String login(String email , String password){
        User user = authenticate(email, password);
    return jwtUtil.generateToken(user.getEmail());
    }
}
