package com.mpolec.studentrest.service.impl;

import com.mpolec.studentrest.dao.StudentRepository;
import com.mpolec.studentrest.entity.StudentEntity;
import com.mpolec.studentrest.response.ResponseDetailsStatusException;
import com.mpolec.studentrest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    private List<String> responseDetails;

    @Override
    public List<StudentEntity> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudent(int studentId) {
        responseDetails = new ArrayList<>();

        return studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    responseDetails.add("Not found student with id - " + studentId);
                    return new ResponseDetailsStatusException(
                            HttpStatus.NOT_FOUND,
                            "Failure",
                            responseDetails
                    );
                });
    }

    @Override
    public void addStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(int studentId) {
        responseDetails = new ArrayList<>();

        studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    responseDetails.add("Not found student with id - " + studentId);
                    return new ResponseDetailsStatusException(
                            HttpStatus.NOT_FOUND,
                            "Failure",
                            responseDetails
                    );
                });

        studentRepository.deleteById(studentId);
    }

    @Override
    public void modifyStudent(StudentEntity studentEntity, int studentId) {
        responseDetails = new ArrayList<>();

        studentRepository.findById(studentId)
                .orElseThrow(() -> {
                    responseDetails.add("Not found student with id - " + studentId);
                    return new ResponseDetailsStatusException(
                            HttpStatus.NOT_FOUND,
                            "Failure",
                            responseDetails
                    );
                });

        studentEntity.setId(studentId);
        studentRepository.save(studentEntity);
    }
}
