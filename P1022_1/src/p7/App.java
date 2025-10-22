package p7;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDto[] arr = new StudentDto[5];
        List<StudentDto> list = new ArrayList<>();
        list.add(new StudentDto("철수"));
        list.add(new StudentDto("영희"));
        list.add(new StudentDto("동훈"));
        list.add(new StudentDto("태호"));

            //리스트에서 값을 뽑아오는 방법
        StudentDto studentDto = list.get(2);
        System.out.println(studentDto.getName());

        System.out.println("=========================");
        for(StudentDto element : list){
            System.out.println(element.getName());

        }
        System.out.println("------------------------");
        // Stream Api - 람다식 사용
        list.forEach((student) ->  System.out.println(student.getName()));
        
    }
}

class StudentDto{
    private String name;
    private int age;
    private int score;

    public StudentDto(String name){
        this.name =name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setScore(int score){
        this.score = score;
    }
}
