package com.ravi.userauthservice.user.repository;

import com.ravi.userauthservice.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User ,Long> {


    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email); // Used during registration ,Prevents duplicate users
}
