package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.FeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<FeesModel, Long> {
}
