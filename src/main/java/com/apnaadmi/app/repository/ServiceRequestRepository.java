package com.apnaadmi.app.repository;

import com.apnaadmi.app.entity.ServiceRequest;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRequestRepository
        extends JpaRepository<ServiceRequest, Long> {

    List<ServiceRequest> findByUser(User user);
}
