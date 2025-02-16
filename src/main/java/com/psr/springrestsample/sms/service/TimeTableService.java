package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.TimeTable;
import com.psr.springrestsample.sms.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeTableService {

    @Autowired
    private TimeTableRepository timeTableRepository;

    // Add or Update Time Table
    public TimeTable saveTimeTable(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    // Get All Time Tables
    public List<TimeTable> getAllTimeTables() {
        return timeTableRepository.findAll();
    }

    // Get Time Table by ID
    public Optional<TimeTable> getTimeTableById(Long timeId) {
        return timeTableRepository.findById(timeId);
    }

    // Delete Time Table
    public void deleteTimeTable(Long timeId) {
        timeTableRepository.deleteById(timeId);
    }
}

