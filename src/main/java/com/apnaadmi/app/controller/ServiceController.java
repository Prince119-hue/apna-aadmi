package com.apnaadmi.app.controller;

import com.apnaadmi.app.entity.ServiceRequest;
import com.apnaadmi.app.entity.User;
import com.apnaadmi.app.repository.ServiceRequestRepository;
import com.apnaadmi.app.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

//@Controller
@RequestMapping("/services")
public class ServiceController {

    private final UserRepository userRepository;
    private final ServiceRequestRepository serviceRequestRepository;

    public ServiceController(UserRepository userRepository,
                             ServiceRequestRepository serviceRequestRepository) {
        this.userRepository = userRepository;
        this.serviceRequestRepository = serviceRequestRepository;
    }

    // Main Services page → /services
    @GetMapping
    public String services() {
        return "services";
    }

    // Personal Support → /services/personal-support
    @GetMapping("/personal-support")
    public String personalSupport() {
        return "personal-support";
    }

    // Event Management → /services/event-management
    @GetMapping("/event-management")
    public String eventManagement() {
        return "event-management";
    }

    // Complete Responsibility → /services/complete-responsibility
    @GetMapping("/complete-responsibility")
    public String completeResponsibility() {
        return "complete-responsibility";
    }

    // BOOK Personal Support → /services/personal-support/book
    @GetMapping("/personal-support/book")
    public String bookPersonalSupport(Principal principal) {

        // Logged-in user
        User user = userRepository
                .findByEmail(principal.getName())
                .orElseThrow();

        // Create request
        ServiceRequest request = new ServiceRequest();
        request.setServiceName("Personal Support");
        request.setStatus("NEW");
        request.setUser(user);

        // Save
        serviceRequestRepository.save(request);

        return "redirect:/user/dashboard";
    }
}
