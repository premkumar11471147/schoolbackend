package com.psr.springrestsample.sms.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psr.springrestsample.sms.model.Teachers;
import com.psr.springrestsample.sms.repository.TeacherRepository;
import com.psr.springrestsample.sms.service.ClasseService;
import com.psr.springrestsample.sms.service.CourseService;
import com.psr.springrestsample.sms.service.TeacherService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers/")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;
    private ClasseService classeService;
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService, ClasseService classeService, TeacherRepository teacherRepository){
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.classeService = classeService;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("teacher/signup")
    public String ViewTeacher(Model model, Teachers teachers){
        model.addAttribute("courses", courseService.listAllCourses());
        model.addAttribute("classes", classeService.getAllClasse());
        return "add-teacher";
    }

    @GetMapping("teacher/list")
    public List<Teachers> showTeacher(Model model){
        return (List<Teachers>) teacherService.getAllTeachers();
        
    }

    @PostMapping("add/teacher")
    public ResponseEntity<List<Teachers>> addteacher(@RequestBody Teachers teacher ){
        if(teacher == null){
            return ResponseEntity.notFound().build();
        }
        Date d = new Date(0);
        teacher.setJndate(d);
        Teachers t = teacherRepository.save(teacher);
        long u = t.getId();
        String s = "TUI00" + u;
        if(s != teacher.getSui()){
            s = "TUI000" + u;
        }
        teacher.setSui(s);
        teacherService.saveTeacher(teacher);
        // model.addAttribute("teachers", teacherService.getAllTeachers());
        // model.addAttribute("classes", classeService.getAllClasse());
        // model.addAttribute("courses", courseService.listAllCourses());

        return ResponseEntity.ok((List<Teachers>) teacherService.getAllTeachers());
    }

    @GetMapping("edit/teacher/{id}")
    public ResponseEntity<Teachers>  editTeacher(@PathVariable("id") long id, @RequestBody Teachers updatedTeacher){
        Teachers existingTeacher = teacherService.findById(id);
        if(existingTeacher == null){
            return ResponseEntity.notFound().build();
        }
        else if(updatedTeacher == null ) {
            return ResponseEntity.noContent().build();
        }

        existingTeacher.setTeaname(updatedTeacher.getTeaname());
        existingTeacher.setTeaemail(updatedTeacher.getTeaemail());
        existingTeacher.setteacourse(updatedTeacher.getTeacourse());
        existingTeacher.setTeaaddress(updatedTeacher.getTeaaddress());
        existingTeacher.setteaphone(updatedTeacher.getTeaphone());
        existingTeacher.setJndate(updatedTeacher.getJndate());
        existingTeacher.setDeptm(updatedTeacher.getDepmt());
        existingTeacher.setSui(updatedTeacher.getSui());
        existingTeacher.setGender(updatedTeacher.getGender());
        existingTeacher.setSection(updatedTeacher.getSection());
        existingTeacher.setClasse(updatedTeacher.getClasse());

        teacherService.saveTeacher(existingTeacher);

        return  ResponseEntity.ok(updatedTeacher);
    }
    
    @PostMapping("updtae/teacher/{id}")
    public ResponseEntity<Teachers> updateTeacher(@PathVariable("id") long id, @RequestBody Teachers updatedTeacher){
        Teachers existingTeacher = teacherService.findById(id);
        if(existingTeacher == null){
            return ResponseEntity.notFound().build();
        }
        else if(updatedTeacher == null ) {
            return ResponseEntity.noContent().build();
        }
        existingTeacher.setTeaname(updatedTeacher.getTeaname());
        existingTeacher.setTeaemail(updatedTeacher.getTeaemail());
        existingTeacher.setteacourse(updatedTeacher.getTeacourse());
        existingTeacher.setTeaaddress(updatedTeacher.getTeaaddress());
        existingTeacher.setteaphone(updatedTeacher.getTeaphone());
        existingTeacher.setJndate(updatedTeacher.getJndate());
        existingTeacher.setDeptm(updatedTeacher.getDepmt());
        existingTeacher.setSui(updatedTeacher.getSui());
        existingTeacher.setGender(updatedTeacher.getGender());
        existingTeacher.setSection(updatedTeacher.getSection());
        existingTeacher.setClasse(updatedTeacher.getClasse());

        teacherService.saveTeacher(existingTeacher);

        return  ResponseEntity.ok(updatedTeacher);
    }

    @GetMapping("delete/teacher/{id}")
    public ResponseEntity<Teachers> deleteTeacher(@PathVariable("id") long id){
       Teachers teachers = (teacherService.findById(id));
       if(teachers == null){
        return ResponseEntity.notFound().build();
        }
        teacherService.deleteTeacher(teachers);
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("view/teacher/{id}")
    public ResponseEntity<Teachers> viewTeacher(@PathVariable("id") long id){
       Teachers  teachers = teacherService.findById(id);
       if(teachers == null){
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teachers);
    }
    
}
