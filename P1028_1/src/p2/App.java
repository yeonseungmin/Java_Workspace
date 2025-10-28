package p2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<StudentDto> list = new ArrayList<>();
        List<StudentDto> list2 = new LinkedList<>();
        list2.add(new StudentDto("한조1"));
        list2.add(new StudentDto("한조2"));        
        list2.add(new StudentDto("한조3"));
        list2.add(new StudentDto("한조4"));

        list2.add(2, new StudentDto("메르시"));

        list2.remove(1);

        System.out.println(list2.get(0).name);
        System.out.println(list2.get(1).name);
        System.out.println(list2.get(2).name);
        System.out.println(list2.get(3).name);


    }
}

class StudentDto{
    StudentDto(String name){
        this.name = name;
    }
    String name;
    int age;
    int score;
} 