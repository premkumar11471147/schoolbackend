package com.psr.springrestsample.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psr.springrestsample.sms.model.SectionModel;
import com.psr.springrestsample.sms.service.SectionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sections/")
public class SectionController {

    private SectionService sectionService;

    @Autowired
    public void setSectionController(SectionService sectionService){
        this.sectionService = sectionService;
    }

    @GetMapping("view/section")
    public String viewSection(){
    return "add-section";
    }

    @GetMapping("show/sections/list")
    public String showSection(Model model){
        model.addAttribute("sections", sectionService.getAllSection());
        return "section";
    }

    @PostMapping("add/section")
    public String newSection(@Valid SectionModel section, Model model){
        sectionService.saveSection(section);
        model.addAttribute("classes", sectionService.getAllSection());
        return "section";
    }

    @GetMapping("edit/section/{id}")
    public String editSection(@PathVariable("id") long id, SectionModel section, Model model, BindingResult result){
        if(result.hasErrors()){
            return "section";
        }
        model.addAttribute("section", section);
        return "section";
    }

    @PostMapping("update/section/{id}")
    public String updateSection(@PathVariable("id") long id, Model model, BindingResult result, SectionModel section){
        if(result.hasErrors()){
            section.setSecId(id);
            return "section";
        }
        sectionService.saveSection(section);
        model.addAttribute("sections", sectionService.getAllSection());
        return "section";
    }
}
