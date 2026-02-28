package com.apnaadmi.app.controller;

import com.apnaadmi.app.entity.User;
import com.apnaadmi.app.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository,
                          BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // REGISTER PAGE
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // REGISTER SUBMIT
    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {

        if (userRepository.findByEmail(email).isPresent()) {
            model.addAttribute("error", "Email already registered");
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("ROLE_USER");

        userRepository.save(user);

        model.addAttribute("success", "Registration successful. Please login.");
        return "login";
    }
}
