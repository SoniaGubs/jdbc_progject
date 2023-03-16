package com.academy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private Integer id;
    private String name;
    private String surname;
    private Integer dob;
    private Integer phone;
    private String title;
    private Integer salary;

    private List <Department> departments;



}
