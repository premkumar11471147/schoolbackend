package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.FeesModel;
import com.psr.springrestsample.sms.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    @Autowired
    private FeesRepository feesRepository;

    // Add or Update Fees
    public FeesModel saveFees(FeesModel fees) {
        return feesRepository.save(fees);
    }

    // Get All Fees
    public List<FeesModel> getAllFees() {
        return feesRepository.findAll();
    }

    // Get Fees by ID
    public Optional<FeesModel> getFeesById(Long receiptId) {
        return feesRepository.findById(receiptId);
    }

    // Delete Fees
    public void deleteFees(Long receiptId) {
        feesRepository.deleteById(receiptId);
    }
}
