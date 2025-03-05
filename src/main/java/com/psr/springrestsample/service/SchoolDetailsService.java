package com.psr.springrestsample.service;


import com.psr.springrestsample.model.SchoolDetailsModel;
import com.psr.springrestsample.repository.SchoolDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolDetailsService {

    @Autowired
    private SchoolDetailsRepository schoolDetailsRepository;

    // Add or Update School Details
    public SchoolDetailsModel saveSchoolDetails(SchoolDetailsModel schoolDetails) {
        return schoolDetailsRepository.save(schoolDetails);
    }

    // Get All School Details
    public List<SchoolDetailsModel> getAllSchoolDetails() {
        return schoolDetailsRepository.findAll();
    }

    // Get School Details by ID
    public Optional<SchoolDetailsModel> getSchoolDetailsById(Long schoolId) {
        return schoolDetailsRepository.findById(schoolId);
    }

    // Delete School Details
    public void deleteSchoolDetails(Long schoolId) {
        schoolDetailsRepository.deleteById(schoolId);
    }
}

