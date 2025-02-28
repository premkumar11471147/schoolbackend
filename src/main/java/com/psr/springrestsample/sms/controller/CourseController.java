package com.psr.springrestsample.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psr.springrestsample.sms.model.CourseModel;
import com.psr.springrestsample.sms.service.CourseService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/courses/")
public class CourseController{
    private final CourseService courseService;


    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping(value="course")
    public String getCourseView(Model model){
        model.addAttribute("course", model);
        return "add-course";
    }

    @GetMapping(value="course/list")
    public String getCourseList(Model model){
        model.addAttribute("courses", courseService.listAllCourses());
        return "course";
    }

    @PostMapping(value="course/add")
    public String addNewCourse(@Valid CourseModel course, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-course";
        }

        courseService.saveCourse(course);
        model.addAttribute("courses", courseService.listAllCourses());
        return "course";
    }
    @GetMapping("course/edit/{id}")
    public String editCourse(@PathVariable("id") long id, CourseModel course, Model model, BindingResult result){
        course = courseService.findById(id);
        model.addAttribute("course", course);

        return "update-course";
    }

    @PostMapping(value = "course/update/{id}")
    public String updateCourse(@PathVariable("id") long id, CourseModel course, Model model, BindingResult result){
        if(result.hasErrors()){
            course.setId(id);
            return "update-course";
        }

        courseService.saveCourse(course);
        model.addAttribute("courses", courseService.listAllCourses());
        return "course";
    }

}