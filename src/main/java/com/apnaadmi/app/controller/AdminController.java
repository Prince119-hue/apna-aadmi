package com.apnaadmi.app.controller;

import com.apnaadmi.app.repository.LeadRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final LeadRepository leadRepository;

    public AdminController(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {

        var leads = leadRepository.findAll();

        model.addAttribute("leads", leads);
        model.addAttribute("totalLeads", leads.size());

        return "admin-dashboard";
    }

}
