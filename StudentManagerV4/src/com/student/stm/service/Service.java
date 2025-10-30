package com.student.stm.service;

import java.util.List;

import com.student.stm.dto.StudentDto;
import com.student.stm.repository.Repository;
import com.student.stm.util.IoManager;

//컴포넌트
//역할 : 비즈니스로직(코어로직) 담당
//실제 액션**************************알고리즘
//(출력문은 따로 만드는게 좋다)
public class Service {
   private Repository repository = new Repository();
   public void addStudent(){
    IoManager.print("============ 학생 정보 입력 ============");
    String name = IoManager.input("이름 입력 > ");
    int age = Integer.parseInt(IoManager.input("나이 입력 > "));
    int score = Integer.parseInt(IoManager.input("점수 입력 > "));

    StudentDto studentDto = new StudentDto(name,age,score);
    repository.save(studentDto);

    IoManager.print("=======================================");
   }

   public void listStudent(){
    IoManager.print("==============학생 목록 ================");
    List<StudentDto> list = repository.findAll();

    for(StudentDto studentDto : list){
        String text ="";
        text += "이름 : "+ studentDto.getName();
        text += ", | 나이" + studentDto.getAge();
        text += ", | 성적" + studentDto.getScore();
        IoManager.print(text);
    }
    IoManager.print("총 인원 : "+ list.size());
    IoManager.print("=======================================");
   }

   public void searchStudent(){
    IoManager.print("================학생 검색=================");
    String searchName = IoManager.input("검색할 이름 : ");
    List<StudentDto> list = repository.findByNameContaining(searchName);

    for(StudentDto studentDto : list){
        String text ="";
        text += "이름 : "+ studentDto.getName();
        text += ", | 나이" + studentDto.getAge();
        text += ", | 성적" + studentDto.getScore();
        IoManager.print(text);
    }
    IoManager.print("검색된 인원 : "+ list.size());
    IoManager.print("=========================================");
   }

   public void removeStudent(){
    IoManager.print("=============학생 정보 삭제=================");
    String deletName = IoManager.input("삭제할 학생의 이름 >");
    int count = repository.removeByName(deletName);
    IoManager.print("총 삭제된 학생의 수: "+ count +"명 입니다.");
    IoManager.print("==========================================");
   }

   public void saveToFile(){
        repository.saveToFile();
   }
   public void loadFromFile(){
         repository.loadFromFile();
   }
}



