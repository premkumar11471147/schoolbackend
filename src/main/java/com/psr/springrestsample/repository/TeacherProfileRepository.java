package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.TeacherProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherProfileRepository extends JpaRepository<TeacherProfileModel, Long> {
    List<TeacherProfileModel> findBySchoolId(Long schoolId);
}
