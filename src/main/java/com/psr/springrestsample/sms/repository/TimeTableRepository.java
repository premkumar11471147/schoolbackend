package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.TimeTableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTableModel, Long> {
}

