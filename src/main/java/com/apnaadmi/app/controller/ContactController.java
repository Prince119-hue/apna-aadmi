package com.apnaadmi.app.controller;

import com.apnaadmi.app.entity.Lead;
import com.apnaadmi.app.service.LeadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private final LeadService leadService;

    public ContactController(LeadService leadService) {
        this.leadService = leadService;
    }

    @GetMapping("/contact")
    public String contactForm() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitForm(@RequestParam String phone, Model model) {

        Lead lead = new Lead();
        lead.setService("Contact Form");
        lead.setPhone(phone);

        leadService.saveLead(lead);

        model.addAttribute("success", "Thanks! Our team will contact you shortly.");

        return "contact";
    }

}
