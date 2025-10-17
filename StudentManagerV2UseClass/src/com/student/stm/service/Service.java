package com.student.stm.service;

import com.student.stm.dto.StudentDto;
import com.student.stm.repository.Repository;
import com.student.stm.util.IoManager;

//컴포넌트
//역할 : 비즈니스로직(코어로직) 담당
public class Service {
    private Repository repository = new Repository();

    public void addStudent(){
        IoManager.print("----------학생 정보 입력 시작--------------");
        String name = IoManager.input("이름 입력 > ");
        int age = Integer.parseInt(IoManager.input("나이 입력 > "));
        int score = Integer.parseInt(IoManager.input("점수 입력 > "));

        StudentDto studentDto = new StudentDto(name, age, score);
        
        repository.save(studentDto);

        IoManager.print("-----------------------------------------");

    }

    public void listStudent(){
        IoManager.print("----------학생 정보 목록 시작--------------");
        StudentDto[] list = repository.findAll();

        for(StudentDto studentDto : list){  //list의 크기에 따라 반복 
            String text = "";
            text += " 이름 : " + studentDto.getName();
            text += " ,나이 : " + studentDto.getAge();
            text += " ,점수 : " + studentDto.getScore();
            IoManager.print(text);
        }

        IoManager.print("총"+ list.length + "명이 존재합니다.");
        
        IoManager.print("-----------------------------------------");
    }
    public void searchStudent(){
        IoManager.print("----------학생 정보 검색 시작--------------");

        String searchWord = IoManager.input("검색 할 이름 >");

        StudentDto[] list = repository.findByNameContaining(searchWord);

        for(StudentDto studentDto : list){  //list의 크기에 따라 반복 
            String text = "";
            text += " 이름 : " + studentDto.getName();
            text += " ,나이 : " + studentDto.getAge();
            text += " ,점수 : " + studentDto.getScore();
            IoManager.print(text);
        }
        IoManager.print("검색된 총 인원은 "+ list.length + "입니다.");

        IoManager.print("-----------------------------------------");
    }
    public void removeStudent(){
        IoManager.print("----------학생 정보 검색 시작--------------");
        String removeName = IoManager.input("삭제할 학생의 이름 > ");
        int count =repository.removeByName(removeName);
        IoManager.print("총" + count + "명의 정보가 삭제되었습니다.");

        IoManager.print("-----------------------------------------");
    }

    public void statistize(){
        IoManager.print("----------학생 정보 통계 시작--------------");
        StudentDto[] list = repository.findAll();
        int sumScore = 0;
        for(StudentDto studentDto : list){
            sumScore += studentDto.getScore();

        }
        double average = sumScore/list.length;
        IoManager.print("총 인원"+ list.length);
        IoManager.print("평균" + average);

        IoManager.print("-----------------------------------------");
    }
}



