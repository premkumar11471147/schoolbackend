package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.TeacherPersonalProfile;
import com.psr.springrestsample.sms.model.TeacherProfile;
import com.psr.springrestsample.sms.repository.TeacherPersonalProfileRepository;
import com.psr.springrestsample.sms.repository.TeacherProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherProfileService {

    @Autowired
    private TeacherProfileRepository teacherProfileRepository;

    @Autowired
    private TeacherPersonalProfileRepository teacherPersonalProfileRepository;

    // Create or Update Teacher Profile with Personal Details
    @Transactional
    public TeacherProfile saveTeacherProfile(TeacherProfile teacherProfile, TeacherPersonalProfile personalProfile) {
        // Link TeacherProfile and TeacherPersonalProfile
        teacherProfile.setTeacherPersonalProfile(personalProfile);
        personalProfile.setTeacherProfile(teacherProfile);

        // Save TeacherProfile (Cascade will also save TeacherPersonalProfile)
        return teacherProfileRepository.save(teacherProfile);
    }


    // Get All Teachers
    public List<TeacherProfile> getAllTeachers() {
        return teacherProfileRepository.findAll();
    }

    // Get Teacher Profile by ID
    public Optional<TeacherProfile> getTeacherById(Long teacherId) {
        return teacherProfileRepository.findById(teacherId);
    }

    // Get Teachers by School ID
    public List<TeacherProfile> getTeachersBySchoolId(Long schoolId) {
        return teacherProfileRepository.findBySchoolId(schoolId);
    }

    // Delete Teacher Profile
    public void deleteTeacher(Long teacherId) {
        teacherPersonalProfileRepository.deleteById(teacherId);
        teacherProfileRepository.deleteById(teacherId);
    }
}

