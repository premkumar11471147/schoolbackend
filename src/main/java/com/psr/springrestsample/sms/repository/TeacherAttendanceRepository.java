package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.TeacherAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherAttendanceRepository extends JpaRepository<TeacherAttendance, Long> {
    List<TeacherAttendance> findByTeacherTeacherId(Long teacherId);
}
