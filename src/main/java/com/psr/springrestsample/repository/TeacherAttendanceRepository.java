package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.TeacherAttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherAttendanceRepository extends JpaRepository<TeacherAttendanceModel, Long> {
    List<TeacherAttendanceModel> findByTeacherTeacherId(Long teacherId);
}
