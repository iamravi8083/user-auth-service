package com.ravi.userauthservice.auth.controller;

import com.ravi.userauthservice.auth.dto.AuthResponse;
import com.ravi.userauthservice.auth.dto.LoginRequest;
import com.ravi.userauthservice.auth.dto.RegisterRequest;
import com.ravi.userauthservice.auth.service.AuthService;
import com.ravi.userauthservice.user.entity.User;
import com.ravi.userauthservice.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService){
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        User user   = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userService.registerUser(user);
        return ResponseEntity.ok(new AuthResponse("user register successfully"));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

        String token = authService.login(
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }

}
