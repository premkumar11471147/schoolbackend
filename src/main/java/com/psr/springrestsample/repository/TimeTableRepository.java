package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.TimeTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableModel, Long> {
}

