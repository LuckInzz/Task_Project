package com.example.todoapi.controller;

import com.example.todoapi.model.User;
import com.example.todoapi.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listAll() {
        return ResponseEntity.ok(userService.listAll());
    }

    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.loginUser(user));
    }

    @GetMapping("/search/{id}")
    public User searchID(@PathVariable Long id) {
        return userService.searchID(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
