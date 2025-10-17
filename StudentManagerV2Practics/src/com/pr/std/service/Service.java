package com.pr.std.service;

import com.pr.std.controller.repository.Repository;
import com.pr.std.dto.StudentDto;
import com.pr.std.util.IoManager;

public class Service {
private Repository repository = new Repository();
    public void addStudent(){
        IoManager.print("학생 정보 시작");
        String name = IoManager.input("이름 입력 > ");
        int age = Integer.parseInt(IoManager.input("나이 입력 > "));
        int score = Integer.parseInt(IoManager.input("점수 입력 > "));
        StudentDto studentDto = new StudentDto(name, age, score);

        repository.save(studentDto);

    }
    public void listStudent(){
        
    }
    public void searchStudent(){
        
    }
    public void removeStudent(){
        
    }
    public void statistize(){
        
    }
}
