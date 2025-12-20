package com.ravi.userauthservice.user.service;

import com.ravi.userauthservice.role.entity.Role;
import com.ravi.userauthservice.role.repository.RoleRepository;
import com.ravi.userauthservice.user.entity.User;
import com.ravi.userauthservice.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("User already exist");
        }
        Role role = roleRepository.findByName("USER")
                .orElseThrow(() ->new RuntimeException("Role not found"));
        user.setRoles(Set.of(role));
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("user not found"));
    }
}
