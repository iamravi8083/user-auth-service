package com.ravi.user_auth_service.role.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ravi.user_auth_service.role.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(String name);
}
