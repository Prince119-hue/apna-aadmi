package com.apnaadmi.app.entity;

public class Lead {

    private Long id;
    private String service;
    private String guests;
    private String members;
    private String phone;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public String getGuests() { return guests; }
    public void setGuests(String guests) { this.guests = guests; }

    public String getMembers() { return members; }
    public void setMembers(String members) { this.members = members; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}