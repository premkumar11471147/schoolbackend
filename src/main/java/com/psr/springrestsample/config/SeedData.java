package com.psr.springrestsample.config;

import com.psr.springrestsample.sms.model.TeacherPersonalProfile;
import com.psr.springrestsample.sms.model.TeacherProfile;
import com.psr.springrestsample.sms.service.TeacherProfileService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.psr.springrestsample.model.Account;
import com.psr.springrestsample.service.AccountService;
import org.springframework.stereotype.Service;


@Component
public class SeedData  implements CommandLineRunner{
   
    

    @Autowired
    private AccountService accountService;

    @Autowired
    private TeacherProfileService teacherProfileService;

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


        java.util.Date utilDate = new java.util.Date(); // Current date and time
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

/*
        for(int i =0; i< 10; i++) {
            TeacherProfile teacher = new TeacherProfile();
            teacher.setSchoolId(100L);
            teacher.setTeacherId(1L);
            teacher.setFirstName("Teacher" + i + "@gmail.com");
            teacher.setLastName("Teacher" + i + "Course");
            teacher.setTeachingClasses("4,5,6" + i + ",hyd");
            teacher.setClassTeacher(true);

            TeacherPersonalProfile teacherPersonalProfile = new TeacherPersonalProfile();


            teacherPersonalProfile.setTeacherId(teacher.getTeacherId());
            teacherPersonalProfile.setDateOfBirth(sqlDate.toString());
            teacherPersonalProfile.setGender("MALE");
            teacherPersonalProfile.setGuardianName("Suresh" + i );
            teacherPersonalProfile.setPhoneNumber("900842523" + i );
            teacherPersonalProfile.setAlternateNumber("9014064845" + i );
            teacherPersonalProfile.setEmailId("abc@abc" + i +".com");
            teacherPersonalProfile.setAddress("plot num" + i +" 100");
            teacherProfileService.saveTeacherProfile(teacher, teacherPersonalProfile);
        }*/

    }


}
