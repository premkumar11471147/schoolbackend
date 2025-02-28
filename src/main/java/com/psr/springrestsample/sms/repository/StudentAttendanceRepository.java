package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.StudentAttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendanceModel, Long> {

    // Fetch attendance for a particular student
    List<StudentAttendanceModel> findByStudentStudentId(Long studentId);

    // Fetch attendance by date
    List<StudentAttendanceModel> findByDate(LocalDate date);
}
