package p1;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //제너릭
        //프레임 워크 개발시 클래스 지역변수에 타입을 지정하지 않고싶음,
        StudentDto3<String> s1 = new StudentDto3<String>(); // T 가 String 타입으로 매칭
        s1.age = "13";
        StudentDto3<Integer> s2 = new StudentDto3<Integer>();
        s2.age = 13;
        
        List<StudentDto3> studentDtos = new ArrayList<>();
        studentDtos.add(s1);
        studentDtos.add(s2);

    }
}
class StudentDto3<T>{   // ( T: Type)
    T name;
    T age; // 예전엔 오브젝트
    T score;   
}

class StudentDto<제너릭_무슨타입인지_몰라_아무글자나_넣을수있어>{  //<> 제너릭 정의 문법
    String name;
    int age;
    제너릭_무슨타입인지_몰라_아무글자나_넣을수있어 score;
}
class StudentDto2<아몰랑>{
    아몰랑 name;
    아몰랑 age;
    아몰랑 score;
}