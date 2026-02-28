package com.apnaadmi.app.controller;

import com.apnaadmi.app.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AuthController {

    private final Map<String, User> users = new HashMap<>();
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               Model model) {

        if (users.containsKey(email)) {
            model.addAttribute("error", "Email already registered");
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // ✅ FIXED
        user.setRole("ROLE_USER");

        users.put(email, user);

        model.addAttribute("success", "Registration successful. Please login.");
        return "login";
    }
}