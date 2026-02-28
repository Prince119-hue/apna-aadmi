package com.apnaadmi.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostLoginController {

    @GetMapping("/post-login")
    public String postLogin(Authentication authentication) {

        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/dashboard";
        }

        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/user/dashboard";
        }

        return "redirect:/";
    }
}