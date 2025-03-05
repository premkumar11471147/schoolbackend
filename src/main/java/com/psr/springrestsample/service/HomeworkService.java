package com.psr.springrestsample.service;


import com.psr.springrestsample.model.HomeworkModel;
import com.psr.springrestsample.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    // Add or Update Homework
    public HomeworkModel saveHomework(HomeworkModel homework) {
        return homeworkRepository.save(homework);
    }

    // Get All Homework Assignments
    public List<HomeworkModel> getAllHomework() {
        return homeworkRepository.findAll();
    }

    // Get Homework by Date
    public Optional<HomeworkModel> getHomeworkByDate(String date) {
        return homeworkRepository.findById(date);
    }

    // Delete Homework
    public void deleteHomework(String date) {
        homeworkRepository.deleteById(date);
    }
}

