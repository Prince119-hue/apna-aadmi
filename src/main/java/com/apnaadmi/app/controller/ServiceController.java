package com.apnaadmi.app.controller;

import com.apnaadmi.app.entity.ServiceRequest;
import com.apnaadmi.app.entity.User;
import com.apnaadmi.app.repository.ServiceRequestRepository;
import com.apnaadmi.app.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
@Profile("db")
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