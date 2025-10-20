package p9;

public class App {
    public static void main(String[] args) {
        AAA aaa = new BBB();        // 문법적으론 AAA 클래스의 test 메소드 실행이지만
        aaa.test();                 // 런타임 상황에선 BBB 클래스의 test 메소드가 실행되어 결과값이 도출된다.
    }
}
//메소드 오버라이딩 : 재정의
class AAA {
    void test(){
        System.out.println("AAA 테스트 호출");
    }
}

class BBB extends AAA{  // 상속받은 매서드 형태 그대로 재정의
    void test(){
        System.out.println("BBB 테스트 호출");
    }
}