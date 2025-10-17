package com.student.stm.repository;

import com.student.stm.dto.StudentDto;

// 컴포넌트
// 역확 : 저장소 - 데이터 입출력 담당
public class Repository {
    private StudentDto[] list = new StudentDto[5];
    private int count=0;

    public void save(StudentDto studentDto){
        list[count] = studentDto;
        count++;
    }
    // public StudentDto[] findAll(){
    //     // 얕은 복사
    //     StudentDto[] newList = new StudentDto[count];

    //     for (int i=0; i<count; i++){
    //         newList[i] = list[i];
    //     }
    //     return newList;
    // }

    public StudentDto[] findAll(){
        // 깊은 복사
        // 코드 복습시 어려우면 
        // 필요한 만큼 배열 복사해서 리턴한다.
        StudentDto[] newList = new StudentDto[count];

        for (int i=0; i<count; i++){
            String name = list[i].getName();
            int age = list[i].getAge();
            int score = list[i].getScore();
            StudentDto studentDto = new StudentDto(name, age, score);
            newList[i] = studentDto;
        }
        return newList;
    }

    public StudentDto[] findByNameContaining(String searchWord){
        int searchCount = 0;
        for(int i =0; i< count; i++){
            if(list[i].getName().contains(searchWord)){
                searchCount ++;
            }
        }
        StudentDto[] newList = new StudentDto[searchCount];
        int newListCount =0;
        for(int i=0; i<count; i++){
            if(list[i].getName().contains(searchWord)){
                String name = list[i].getName();
                int age = list[i].getAge();
                int score = list[i].getScore();
                StudentDto studentDto = new StudentDto(name,age,score);
                newList[newListCount] = studentDto;
            }
        }
        
        return newList;
    }

    public int removeByName(String removeName){
        int removeCount =0;

        for(int i =0; i< count; i++){
            if(list[i].getName().equals(removeName)){
                for(int x = i; x< count-1; x ++){
                    list[x] = list[x+1];

                }
                count --;
                i--;
                removeCount++;
            }
        }
        return removeCount;
    }
}
