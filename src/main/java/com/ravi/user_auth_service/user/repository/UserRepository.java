package com.ravi.user_auth_service.user.repository;

import com.ravi.user_auth_service.user.entity.User;

import java.util.Optional;

public interface UserRepository {


    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email); // Used during registration ,Prevents duplicate users
}
