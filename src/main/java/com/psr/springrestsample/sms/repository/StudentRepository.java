package com.psr.springrestsample.sms.repository;


//import org.idrice24.entities.Classe;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
//import org.springframework.data.repository.query.Param;

import com.psr.springrestsample.sms.model.Student;

@Component
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findById(long id);

   // @Query(value = "SELECT s FROM Student s WHERE Student.sui LIKE : classe ")
   // List<Student> findBySui(@Param("classe") Class<? extends Classe> s);

}
