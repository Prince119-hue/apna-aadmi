package com.apnaadmi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("leads", 0);
        model.addAttribute("totalLeads", 0);

        return "admin-dashboard";
    }
}