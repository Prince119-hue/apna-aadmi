package com.apnaadmi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceController {

    // MAIN SERVICES PAGE
    @GetMapping
    public String services() {
        return "services"; // templates/services.html
    }

    // PERSONAL SUPPORT
    @GetMapping("/personal-support")
    public String personalSupport() {
        return "personal-support";
    }

    // DAILY SERVICES
    @GetMapping("/daily-services")
    public String dailyServices() {
        return "daily-services";
    }

    // EVENT MANAGEMENT
    @GetMapping("/event-management")
    public String eventManagement() {
        return "event-management";
    }

    // COMPLETE RESPONSIBILITY
    @GetMapping("/complete-responsibility")
    public String completeResponsibility() {
        return "complete-responsibility";
    }
}