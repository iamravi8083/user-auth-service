package com.ravi.userauthservice.repository;

import com.ravi.userauthservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);

}
