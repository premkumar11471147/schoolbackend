package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.TeacherProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherProfileRepository extends JpaRepository<TeacherProfileModel, Long> {
    List<TeacherProfileModel> findBySchoolId(Long schoolId);
}
