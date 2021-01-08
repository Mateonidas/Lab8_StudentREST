package com.mpolec.studentrest.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonView
    private String name;

    @JsonView
    private String surname;

    @JsonView
    private Double average;
}
