public class Q2 {
    public static void main(String[] args) {
        // StudentDto s1 = new StudentDto();
        // StudentDto s2 = new StudentDto();
        // s1.name ="홍길동";
        // s1.age=30;
        // s1.score=70;
        // s2.name ="철수";
        // s2.age=40;
        // s2.score =80;
        
        StudentDto[] arr = new StudentDto[5];   // 배열 생성 문법
        //arr[0].name = "홍길동"; NullPointException; 인스턴스가 생성이 안되있음
        arr[0] = new StudentDto();  // 인스턴스 생성문법
        arr[1] = new StudentDto();  // 인스턴스 생성문법
        arr[2] = new StudentDto();  // 인스턴스 생성문법
        arr[3] = new StudentDto();  // 인스턴스 생성문법
        arr[4] = new StudentDto();  // 인스턴스 생성문법
        arr[0].name = "홍길동";

        StudentDto s1 = new StudentDto();
        s1.additionalInfo =  new AdditionalInfo(); // 메모리를 엮어주는 과정
        s1.additionalInfo.gender = "남자"; // 메모리를 엮어주지 않으면 기본값 null
    }
}

class StudentDto {
    String name;
    int age;
    int score;

    AdditionalInfo additionalInfo;
}

class AdditionalInfo{
    String gender;
    String birth;
}
