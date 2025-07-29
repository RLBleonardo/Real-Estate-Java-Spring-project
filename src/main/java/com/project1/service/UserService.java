package com.project1.service;

import com.project1.entity.UserEntity;
import com.project1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserEntity createUser(UserEntity userEntity) {
        if (userRepository.existsByUsername(userEntity.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.existsByEmail(userEntity.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return userRepository.save(userEntity);
    }

    public UserEntity getUserById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public UserEntity updateUser(Long userId, UserEntity updatedUser) {
        UserEntity existingUser = userRepository.findByUserId(userId);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setRole(updatedUser.getRole());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        UserEntity existingUser = userRepository.findByUserId(userId);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.delete(existingUser);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

}
