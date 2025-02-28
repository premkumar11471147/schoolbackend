package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {
}
