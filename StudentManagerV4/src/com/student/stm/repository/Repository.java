package com.student.stm.repository;

import java.util.ArrayList;
import java.util.List;
import com.student.stm.dto.StudentDto;

// 컴포넌트
// 역확 : 저장소 - 데이터 입출력 담당
// 이 부분은 사실상 DB 쿼리로 변경 예정
// ***********배열 .... 저장소***
public class Repository {
    private List<StudentDto> list = new ArrayList<>();

    public void save(StudentDto studentDto){
        list.add(studentDto);
    }

    public List<StudentDto> findAll(){
        return list;
    }

    public List<StudentDto> findByNameContaining(String searchWord){
        List<StudentDto> newList = new ArrayList<>();   // 새로운 배열로 복사하여 리턴

        for(StudentDto studentDto : list){
            if(studentDto.getName().contains(searchWord)){
                newList.add(studentDto);
            }
        }

        return newList;
    }

    public int removeByName(String removeName){
        int count=0;
        for(int i =0; i<list.size(); i++){
            if(list.get(i).getName().equals(removeName)){
                list.remove(i);
                i--;
                count++;
            }
        }
        return count;
    }

}
