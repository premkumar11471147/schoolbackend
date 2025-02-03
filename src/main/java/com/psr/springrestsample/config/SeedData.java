package com.psr.springrestsample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.psr.springrestsample.model.Account;
import com.psr.springrestsample.service.AccountService;
import com.psr.springrestsample.sms.model.Student;
import com.psr.springrestsample.sms.model.Teachers;
import com.psr.springrestsample.sms.service.StudentService;
import com.psr.springrestsample.sms.service.TeacherService;

@Component
public class SeedData  implements CommandLineRunner{
   
    

    @Autowired
    private AccountService accountService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

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

        for(int i =0; i< 10; i++) {
        Teachers teacher = new Teachers();
        teacher.setTeaname("Teacher1"+i);
        teacher.setTeaemail("Teacher"+i+"@gmail.com");
        teacher.setteacourse("Teacher"+i+"Course");
        teacher.setTeaaddress("road"+i+",hyd");
        teacher.setteaphone("9876543210"+i+"");
        teacher.setJndate(sqlDate);
        teacher.setDeptm("maths"+i+"");
        teacher.setSui("sui"+i+"");
        teacher.setGender("MALE");
        teacher.setSection("A"+i+"");
        teacher.setClasse("Class"+i+"");
        teacherService.saveTeacher(teacher);
    }

        for(int i= 0; i< 10; i++) {
            Student student =  new Student();
            student.setFullname("Fullname"+i+"");
            student.setEmail("student"+i+"@gmail.com");
            student.setPhoneno("123456789"+i+"");
            student.setSui("STUDsui"+i+"");
            student.setDob(sqlDate.toString());
            student.setPob("pob"+i+"");
            student.setGender("FEMALE");
            student.setAddress("road"+i+",hyd");
            student.setSection("A"+i+"");
            student.setClasse("Class"+i+"");
            studentService.saveStudent(student);
        }



      
    }


}
