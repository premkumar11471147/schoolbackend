package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Fees;
import com.psr.springrestsample.sms.model.Student;

public interface FeesService {

    Iterable<Fees> getAllFees();

    void save(Fees fees);

    Fees findById(long id);
    
    void delete(Fees fees);

    Student findBySui(String string);

    long count();
    
}
