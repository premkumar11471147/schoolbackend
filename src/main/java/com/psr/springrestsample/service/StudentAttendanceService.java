package com.psr.springrestsample.service;

import com.psr.springrestsample.model.StudentAttendanceModel;
import com.psr.springrestsample.repository.StudentAttendanceRepository;
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
    public StudentAttendanceModel saveAttendance(StudentAttendanceModel attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get All Attendance Records
    public List<StudentAttendanceModel> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get Attendance by Student ID
    public List<StudentAttendanceModel> getAttendanceByStudent(Long studentId) {
        return attendanceRepository.findByStudentStudentId(studentId);
    }

    // Get Attendance by Date
    public List<StudentAttendanceModel> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    // Get Attendance by ID
    public Optional<StudentAttendanceModel> getAttendanceById(Long attendanceId) {
        return attendanceRepository.findById(attendanceId);
    }

    // Delete Attendance Record
    public void deleteAttendance(Long attendanceId) {
        attendanceRepository.deleteById(attendanceId);
    }
}

