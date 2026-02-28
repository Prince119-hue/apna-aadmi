package com.apnaadmi.app.service;

import com.apnaadmi.app.entity.Lead;
import com.apnaadmi.app.repository.LeadRepository;
import org.springframework.stereotype.Service;

@Service
public class LeadService {

    private final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Lead saveLead(Lead lead) {
        return leadRepository.save(lead);
    }
}
