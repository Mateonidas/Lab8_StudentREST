package com.mpolec.studentrest.service;

import com.mpolec.studentrest.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<StudentEntity> getStudentList();

    StudentEntity getStudent(int studentId);

    void addStudent(StudentEntity studentEntity);

    void deleteStudent(int studentId);

    void modifyStudent(StudentEntity studentEntity, int studentId);
}
