package com.mpolec.studentrest.restController;

import com.mpolec.studentrest.entity.StudentEntity;
import com.mpolec.studentrest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentEntity> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/students/{studentId}")
    public StudentEntity getStudent(@PathVariable int studentId) {
        return studentService.getStudent(studentId);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody StudentEntity studentEntity){
        studentService.addStudent(studentEntity);
    }

    @PutMapping("/students/{studentId}")
    public void modifyStudent(@RequestBody StudentEntity studentEntity, @PathVariable int studentId){
        studentService.modifyStudent(studentEntity, studentId);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        studentService.deleteStudent(studentId);
    }
}
