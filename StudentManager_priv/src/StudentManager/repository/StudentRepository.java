package StudentManager.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StudentRepository {
    List<Map<String,Object>> list = new ArrayList<>();
    Map<String,Object> studentMap = new HashMap<>();


    public void save(String name , int studentId){
        studentMap.put(name, studentMap);
        list.add(studentMap);
    }

    public Map<String,Object> findStudent(String name){
        
        if(list.isEmpty()){
            // System.out.println("등록된 학생이 없습니다.");
            return ;
        }else if(studentMap.containsKey(name)){

            // System.out.println("이름: " + name + ", |학번: " + studentId);
        }else {
            // System.out.println(" 이름 [" + name + "]에 해당하는 학생을 찾을 수 없습니다.");
        }
    }
}
