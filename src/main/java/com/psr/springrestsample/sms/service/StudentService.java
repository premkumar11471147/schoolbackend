package com.psr.springrestsample.sms.service;

import com.psr.springrestsample.sms.model.Student;

//import java.util.List;

//import org.idrice24.entities.Classe;

public interface StudentService {

    Iterable<Student> listAllStudents();

    void saveStudent(Student student);

    long getLastId();

    //List<Student> findByClasse(Class<? extends Classe> s);
}
