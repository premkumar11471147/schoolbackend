package com.psr.springrestsample.sms.repository;

import com.psr.springrestsample.sms.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventModel, Long> {
}
