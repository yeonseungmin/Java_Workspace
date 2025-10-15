public class Q3 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("프로그램 시작");
        System.out.println("인스턴스 생성 전");
        Student1 s1 = new Student1(a);   // 1.인스턴스 생성 2.생성자 호출 3. 변수에 값 저장
                                        // 괄호 안에 매게변수 전달가능
        System.out.println("인스턴스 생성 후");
        s1.name = "철수";
        s1.age = 20;
        s1.score = 70;

        Student1 s2 = new Student1("영희",10,20);


        System.out.println("프로그램 끝");
    }
}


class Student1 {
    // 속성(필드), 인스턴스 변수, 멤버 변수
    String name;
    int age;
    int score;

    // 생성자   (일반적으로 초기화 목적)
    Student1(int b){     // 내부에 매게변수 , 파라미터 선언가능 **************
        // 실행 되는 코드 부분
        System.out.println("Student1 생성자 부분 실행");
    }
    Student1(String a,int b,int score){
        System.out.println("name 는" + a);
        System.out.println("age 는" + b);
        System.out.println("score 는" + score);
        this.name = a;
        this.age = b;
        this.score = score;

    }
}
