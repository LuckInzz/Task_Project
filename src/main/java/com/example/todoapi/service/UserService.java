package com.example.todoapi.service;

import com.example.todoapi.model.User;
import com.example.todoapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public Optional<User> searchID(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }
        return userRepository.save(user);
    }

    public User loginUser(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Email not registered");
        }
        User userFound = userOptional.get();
        if (!userFound.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password");
        }
        
        return userFound;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
