package com.student.stm;

import com.student.stm.controller.Controller;

// import com.student.stm.dto.StudentDto;

public class App {
    public static void main(String[] args) {
        // // 1. 데이터 구조(Dto)
        //    2. Controller  
        // 연습은 다 짜고 하나하나 분리하는게 편하다.
        // StudentDto studentDto = new StudentDto();
        // studentDto.setName("한조"); // ( public 용 ) s1.name = "한조"
        // String aaa = studentDto.getName(); //(public 용) String aaa = s1.name;
        new Controller().run();

    }
}
