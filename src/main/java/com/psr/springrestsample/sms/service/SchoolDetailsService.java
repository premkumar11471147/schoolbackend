package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.SchoolDetails;
import com.psr.springrestsample.sms.repository.SchoolDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolDetailsService {

    @Autowired
    private SchoolDetailsRepository schoolDetailsRepository;

    // Add or Update School Details
    public SchoolDetails saveSchoolDetails(SchoolDetails schoolDetails) {
        return schoolDetailsRepository.save(schoolDetails);
    }

    // Get All School Details
    public List<SchoolDetails> getAllSchoolDetails() {
        return schoolDetailsRepository.findAll();
    }

    // Get School Details by ID
    public Optional<SchoolDetails> getSchoolDetailsById(Long schoolId) {
        return schoolDetailsRepository.findById(schoolId);
    }

    // Delete School Details
    public void deleteSchoolDetails(Long schoolId) {
        schoolDetailsRepository.deleteById(schoolId);
    }
}

