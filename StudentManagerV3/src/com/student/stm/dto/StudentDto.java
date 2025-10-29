package com.student.stm.dto;

// Dto : Data Transfer Object 기능없음, 자료 형태를 묶어두기 위한 클래스
public class StudentDto {
    // 핵심은 속성 : 속성은 private !
    // 아래 코드는 모든 속성의 생성자 + get,set 문법
    // 나중에는 클래스 위에 @Data 만 붙이면 자동으로 만들어줌 ***********************
    private String name;
    private int age;
    private int score;
    
    
    // All Argument Constructor
    public StudentDto(String name, int age, int score){
        this.name = name;
        this.age = age;
        this.score = score;
    }
    // No Argument Constructor
    public StudentDto() {}

    // get, set 메서드 생성 필요 : 문법은 메서드 지만, 기능으로 분류 X
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

}
