package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.ExamTimeTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamTimeTableRepository extends JpaRepository<ExamTimeTableModel, Long> {
}
