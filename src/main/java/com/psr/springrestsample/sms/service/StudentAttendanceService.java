package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.StudentAttendance;
import com.psr.springrestsample.sms.repository.StudentAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentAttendanceService {

    @Autowired
    private StudentAttendanceRepository attendanceRepository;

    // Add or Update Attendance
    public StudentAttendance saveAttendance(StudentAttendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get All Attendance Records
    public List<StudentAttendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get Attendance by Student ID
    public List<StudentAttendance> getAttendanceByStudent(Long studentId) {
        return attendanceRepository.findByStudentStudentId(studentId);
    }

    // Get Attendance by Date
    public List<StudentAttendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    // Get Attendance by ID
    public Optional<StudentAttendance> getAttendanceById(Long attendanceId) {
        return attendanceRepository.findById(attendanceId);
    }

    // Delete Attendance Record
    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }
}

