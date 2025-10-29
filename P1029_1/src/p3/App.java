package p3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Map<String,Student> map = new HashMap<>();  //map 하나가 하나의 학생정보
        // key 를 데이터로 사용하겠다.  원래 key는 데이터 용도로 사용하는건 나쁜케이스
    //     map.put("한조", new Student());     // Map 만 가지고 가능
    //     map.put("영희", new Student());
    //     map.put("구마", new Student());
    //     map.put("유시", new Student());
    // }
        Map<String,TodoAdditionalData> todos = new HashMap<>();
        todos.put("러닝하기!!3",new TodoAdditionalData()); 
        todos.put("러닝하기!!1",new TodoAdditionalData());   // 키는 중복을 허용하지 않는다.
        todos.put("러닝하기!!2",new TodoAdditionalData());  

        // for( : todos)     map은 이런식으로 돌릴수 없다.
        Set<String> keys = todos.keySet();  //Set 은 돌릴수 있따.
        for(String key : keys){
            TodoAdditionalData data = todos.get(key);
            System.out.println("키: " + key + ", 값 : "+ data.후기);    //key의 문자열이 작은값부터 정렬되서 나옴
        }
        
    }

}
// 할일 관리( Date 타입)
// 데이터 : 할일, 등록일, 완료일, 완료여부, 후기,
// 문제의 의도 <날짜타입,HashMap

class Student{
    int age;
    int score;
    // name 이 존재하지 않음

}

class TodoAdditionalData{
    LocalDate 등록일;
    LocalDate 완료일;
    boolean 완료여부;
    String 후기;
}