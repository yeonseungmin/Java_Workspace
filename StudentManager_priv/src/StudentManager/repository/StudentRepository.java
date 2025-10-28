package StudentManager.repository;

import java.util.HashMap;
import java.util.Map;


public class StudentRepository {
    HashMap<String,Integer> studentList = new HashMap<>();
    
    public void save(String name , int studentId){
        if(studentList.containsKey(name)){
            System.out.println("이미 등록된 이름입니다.");
            return;
        }else{
            studentList.put(name, studentId);    
        }
        
    }
    public void findStudent(String name){
        if(studentList.isEmpty()){
            System.out.println("등록된 학생이 없습니다.");
            return;
        }else if(studentList.containsKey(name)){
            Integer studentId = studentList.get(name);
            System.out.println("이름: " + name + ", 학번: " + studentId);
        }else {
            System.out.println(" 이름 [" + name + "]에 해당하는 학생을 찾을 수 없습니다.");
        }
    }
}
