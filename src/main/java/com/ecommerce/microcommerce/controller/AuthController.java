package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.UserRepository;
import com.ecommerce.microcommerce.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser user) {
        // Encoder le mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Par défaut on donne le rôle ROLE_USER
        user.setRole("ROLE_USER");

        AppUser savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
