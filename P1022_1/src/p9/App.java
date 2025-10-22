package p9;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //여기가 Service 내부코드라는 가정
        // Repository 에서 getList() 호출했따.
        //근데 Repository 에서는 StudentEntity로 결과를 줬다.
        // 다시 Controller로 배열을 리턴해야하는데, StudentDto 배열로 리턴해야한다.

        List<StudentEntity> entitieList = new ArrayList<>();
        entitieList.add(new StudentEntity("한조",30,99));
        entitieList.add(new StudentEntity("김철수",30,99));
        entitieList.add(new StudentEntity("김영희",30,99));
        entitieList.add(new StudentEntity("길동",30,99));

        // // 위 처럼 Repository에서 배열을 Service에 전달했다.
        // // 문제: StudentEntity -> StudentDto배열로 변환해라.
        // List<StudentDto> dtoList = new ArrayList<>();
        // for(StudentEntity entity : entitieList){
        //     // StudentDto studentDto1 =entity.toDto();
        //     //아래 코드를 알고 구현할줄 알아야 람다식이 편하다.
        //     StudentDto studentDto =StudentDto.fromEntity(entity);
        //     dtoList.add(studentDto);

        // }
        //dtoList 리턴한다.
        //현업에서 가장 많이쓰는 API map Mapping 의 약어
        entitieList.stream()
            .map(StudentDto::fromEntity);
    }
}

class StudentDto{
    private String name;
    private int age;
    private int score;
    
    //Entitiy -> Dto 변환 (보통은 From 을 더 선호)[아래쪽에 to메서드와 같은 기능]
    public static StudentDto fromEntity(StudentEntity entity){
        return new StudentDto(entity.getName(), entity.getAge(), entity.getScore());
    }
    public StudentDto(String name, int age, int score){
        this.name = name;
        this.age = age;
        this.score = score;

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
    public int getAge(){
        return age;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }

}

class StudentEntity{
        private String name;
    private int age;
    private int score;
    
    public StudentEntity(String name, int age, int score){
        this.name = name;
        this.age = age;
        this.score = score;

    }

    //Entity -> Dto 변환 메서드
    public StudentDto toDto(){
        return new StudentDto(name, age, score);
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
    public int getAge(){
        return age;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
}