package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long> {

    // Fetch attendance for a particular student
    List<StudentAttendance> findByStudentStudentId(Long studentId);

    // Fetch attendance by date
    List<StudentAttendance> findByDate(LocalDate date);
}
