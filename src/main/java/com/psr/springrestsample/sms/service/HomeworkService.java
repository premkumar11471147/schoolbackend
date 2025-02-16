package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.Homework;
import com.psr.springrestsample.sms.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    // Add or Update Homework
    public Homework saveHomework(Homework homework) {
        return homeworkRepository.save(homework);
    }

    // Get All Homework Assignments
    public List<Homework> getAllHomework() {
        return homeworkRepository.findAll();
    }

    // Get Homework by Date
    public Optional<Homework> getHomeworkByDate(String date) {
        return homeworkRepository.findById(date);
    }

    // Delete Homework
    public void deleteHomework(String date) {
        homeworkRepository.deleteById(date);
    }
}

