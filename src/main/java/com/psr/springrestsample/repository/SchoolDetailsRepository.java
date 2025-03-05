package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.SchoolDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDetailsRepository extends JpaRepository<SchoolDetailsModel, Long> {
}

