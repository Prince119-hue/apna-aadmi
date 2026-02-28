package com.apnaadmi.app.service;

import com.apnaadmi.app.entity.Lead;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    private final List<Lead> leads = new ArrayList<>();

    public Lead saveLead(Lead lead) {
        leads.add(lead);
        return lead;
    }
}