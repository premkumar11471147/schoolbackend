package com.psr.springrestsample.sms.service;


import com.psr.springrestsample.sms.model.TeacherAttendanceModel;
import com.psr.springrestsample.sms.repository.TeacherAttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherAttendanceService {

    private final TeacherAttendanceRepository teacherAttendanceRepository;

    public TeacherAttendanceService(TeacherAttendanceRepository teacherAttendanceRepository) {
        this.teacherAttendanceRepository = teacherAttendanceRepository;
    }

    // Save Attendance Record
    public TeacherAttendanceModel saveAttendance(TeacherAttendanceModel attendance) {
        return teacherAttendanceRepository.save(attendance);
    }

    // Get All Attendance Records
    public List<TeacherAttendanceModel> getAllAttendance() {
        return teacherAttendanceRepository.findAll();
    }

    // Get Attendance by ID
    public Optional<TeacherAttendanceModel> getAttendanceById(Long attendanceId) {
        return teacherAttendanceRepository.findById(attendanceId);
    }

    // Get Attendance by Teacher ID
    public List<TeacherAttendanceModel> getAttendanceByTeacherId(Long teacherId) {
        return teacherAttendanceRepository.findByTeacherTeacherId(teacherId);
    }

    // Update Attendance Record
    public TeacherAttendanceModel updateAttendance(Long attendanceId, TeacherAttendanceModel updatedAttendance) {
        return teacherAttendanceRepository.findById(attendanceId)
                .map(attendance -> {
                    attendance.setDate(updatedAttendance.getDate());
                    attendance.setAbsent(updatedAttendance.getAbsent());
                    attendance.setAbsentReason(updatedAttendance.getAbsentReason());
                    return teacherAttendanceRepository.save(attendance);
                }).orElseThrow(() -> new RuntimeException("Attendance record not found"));
    }

    // Delete Attendance Record
    public void deleteAttendance(Long attendanceId) {
        teacherAttendanceRepository.deleteById(attendanceId);
    }
}

