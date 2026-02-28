package com.apnaadmi.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @GetMapping
    public String services() {
        return "services";
    }

    @GetMapping("/personal-support")
    public String personalSupport() {
        return "personal-support";
    }

    @GetMapping("/event-management")
    public String eventManagement() {
        return "event-management";
    }

    @GetMapping("/complete-responsibility")
    public String completeResponsibility() {
        return "complete-responsibility";
    }
}