package com.apnaadmi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAuthController {

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin-login";
    }
}
