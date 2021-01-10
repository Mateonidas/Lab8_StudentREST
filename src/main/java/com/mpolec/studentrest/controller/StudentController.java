package com.mpolec.studentrest.controller;

import com.mpolec.studentrest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String getRootContent(){
        return "home/index";
    }

    @GetMapping("/addStudent")
    public String addStudent(){
        return "home/add-student";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(){
        return "home/update-student";
    }
}
