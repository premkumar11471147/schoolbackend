package com.psr.springrestsample.sms.repository;


import com.psr.springrestsample.sms.model.FeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<FeesModel, Long> {
}
