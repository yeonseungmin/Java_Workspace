package com.pr.std.controller.repository;

import com.pr.std.dto.StudentDto;

public class Repository {
    private StudentDto[] list = new StudentDto[5];
    private int count=0;


    public void save(StudentDto studentDto){
        list[count] = studentDto;
        count++;
    }
}
