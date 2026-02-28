package com.apnaadmi.app.controller;

import com.apnaadmi.app.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class AuthController {

    // Temporary in-memory users (NO DATABASE)
    private final Map<String, User> users = new HashMap<>();

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

        if (users.containsKey(email)) {
            model.addAttribute("error", "Email already registered");
            return "register";
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // plain text temporary
        user.setRole("ROLE_USER");

        users.put(email, user);

        model.addAttribute("success", "Registration successful. Please login.");
        return "login";
    }
}