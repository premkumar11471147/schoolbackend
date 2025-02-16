package com.psr.springrestsample.config;

import com.psr.springrestsample.sms.DTO.StudentDto;
import com.psr.springrestsample.sms.model.*;
import com.psr.springrestsample.sms.repository.ClassRepository;
import com.psr.springrestsample.sms.repository.StudentProfileRepository;
import com.psr.springrestsample.sms.service.ClassService;
import com.psr.springrestsample.sms.service.StudentProfileService;
import com.psr.springrestsample.sms.service.TeacherProfileService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.psr.springrestsample.model.Account;
import com.psr.springrestsample.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Component
public class SeedData  implements CommandLineRunner {


    @Autowired
    private AccountService accountService;

    @Autowired
    private TeacherProfileService teacherProfileService;

    @Autowired
    private StudentProfileRepository studentProfileRepository;


    @Autowired
    private StudentProfileService studentProfileService;

    @Autowired
    private ClassService classService;


    @Autowired
    private ClassRepository classRepository;

    @Override
    public void run(String... args) throws Exception {

        Account account1 = new Account();
        Account account2 = new Account();


        account1.setEmail("user@user.com");
        account1.setPassword("pass987");
        account1.setRole("ROLE_USER");
        accountService.save(account1);


        account2.setEmail("admin@admin.com");
        account2.setPassword("pass987");
        account2.setRole("ROLE_ADMIN");
        accountService.save(account2);


        Date utilDate = new Date(); // Current date and time
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


        for (long i = 1; i < 10; i++) {
            ClassEntity classEntity = new ClassEntity();
            classEntity.setClassId(i);
            classEntity.setClassName("5th" + i);
            classEntity.setClassSection("a");

            classService.saveClass(classEntity);
        }

        Optional<ClassEntity> classEntityOptional = classRepository.findById(1L);
        if (classEntityOptional.isPresent()) {
            ClassEntity classEntity = classEntityOptional.get();

            for (long i = 1; i <= 10; i++) {
                // Creating a student profile
                StudentProfile student = new StudentProfile();
                student.setClassEntity(classEntity);
                student.setAdmissionId("stud001"+i);
                student.setFirstName("John"+i);
                student.setLastName("Doe"+i);
                student.setRollNumber("R001"+i);
                student.setSchoolId(1L);

// Creating personal profile (but no ID set directly)
                StudentPersonalProfile personalProfile = new StudentPersonalProfile();
                personalProfile.setPhoto("photo.jpg"+i);
                personalProfile.setDateOfBirth("2001-01-01"+i);
                personalProfile.setGender("Male");
                personalProfile.setFatherName("Mr. Doe"+i);
                personalProfile.setMotherName("Mrs. Doe"+i);
                personalProfile.setPhoneNumber("9876543210"+i);
                personalProfile.setAddress("123 Street"+i);

// Linking both profiles
                student.setStudentPersonalProfile(personalProfile);

// Saving student (this will automatically save personal profile)
                studentProfileRepository.save(student);

            }

            System.out.println("✅ Successfully seeded 10 students into the database!");
        }
    }
}
