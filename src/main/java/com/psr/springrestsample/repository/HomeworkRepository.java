package com.psr.springrestsample.repository;


import com.psr.springrestsample.model.HomeworkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkModel, String> {
}
