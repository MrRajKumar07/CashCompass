package com.demo.Cash_Compass.controller;

import com.demo.Cash_Compass.entity.User;
import com.demo.Cash_Compass.repository.UserRepository;
import com.demo.Cash_Compass.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:6060")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "Username is already taken!"));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        return userRepository.findByUsername(user.getUsername())
                .filter(foundUser -> passwordEncoder.matches(user.getPassword(), foundUser.getPassword()))
                .map(foundUser -> {
                    String token = jwtUtil.generateToken(foundUser.getUsername());
                    return ResponseEntity.ok(Collections.singletonMap("token", token));
                })
                .orElse(ResponseEntity.badRequest().body(Collections.singletonMap("message", "Invalid username or password")));
    }
}
