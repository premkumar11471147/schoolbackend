package com.psr.springrestsample.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psr.springrestsample.sms.model.Student;
import com.psr.springrestsample.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> listAllStudents() {
        

        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        

        studentRepository.save(student);
        
    }

    @Override
    public long getLastId() {
        return studentRepository.count();
    }
    
}