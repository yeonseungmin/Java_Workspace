package p2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<StudentDto> list = new ArrayList<>();      //ArryList , LinkedList 모듈을 서로 교체해도 같은 결과, BUT add 알고리즘이 다름
        List<StudentDto> list2 = new LinkedList<>();    //ArryList 배열처럼 행동 삽입 삭제시 밀어넣기
        list2.add(new StudentDto("한조1"));             //LinkedList  next 의 링크를 관리
        list2.add(new StudentDto("한조2"));        
        list2.add(new StudentDto("한조3"));
        list2.add(new StudentDto("한조4"));
                                                    // ArrayList 는 밀어넣기 형식이라 삽입 삭제가 빈번히 일어나면 LinkedList로 바꾸는게 낫다.
        list2.add(2, new StudentDto("메르시"));     // ---- ArrayList 사용시에는 상당한 주의 요함 (삽입)[LinkedList 전용이라봐도 무방]

        list2.remove(1);// ---- ArrayList 사용시에는 상당한 주의 요함 (삭제)[LinkedList 전용이라봐도 무방]

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