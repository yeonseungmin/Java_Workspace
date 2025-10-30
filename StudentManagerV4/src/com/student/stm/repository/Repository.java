package com.student.stm.repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.ArrayList;
import java.util.List;
import com.student.stm.dto.StudentDto;
import com.student.stm.util.IoManager;

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

    public void saveToFile(){   // 파일 포멧 - 메타데이터(헤더) + RAW DATA 
        File file = new File("C:\\Temp\\stm.dat");
        try (FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos)) {

                // 시그니쳐 Meta DATA 
                dos.writeByte('S');
                dos.writeByte('T');
                dos.writeByte('M');
                dos.writeInt(list.size());   // 파일에 몇명의 학생이 존재하는지;

                // RAW DATA 부분
            for(StudentDto studentDto : list){
                dos.writeUTF(studentDto.getName());
                dos.writeInt(studentDto.getAge());
                dos.writeInt(studentDto.getScore());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public void loadFromFile(){
        File file = new File("C:\\Temp\\stm.dat");

        if(!file.exists()){
            return;
        }

        try(FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis)) {

                //시그니쳐 확인
            if(dis.readByte() != 'S' || dis.readByte() != 'T' || dis.readByte() != 'M'){
                IoManager.print("지원되지 않는 파일 형식입니다.");
                return;
            }

            //카운트 확인
            int count = dis.readInt();
            //RAW DATA 읽기
            for(int i=0; i<count; i++){
                String name = dis.readUTF();
                int age = dis.readInt();
                int score = dis.readInt();
                list.add(new StudentDto(name,age,score));
            }

            IoManager.print("파일이 정상적으로 로드 되었습니다.");
            
        } catch (Exception e) {
            e.setStackTrace(null);
            // TODO: handle exception
        }
    }
}
