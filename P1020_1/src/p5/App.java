package p5;

public class App {
    public static void main(String[] args) {
        // [상속 - 다형성 - 오버라이딩] > [다형성]
        // 문법 의도: 결합도를 낮춘다. > 컴포넌트를 조립식 프로그램으로 만들자 
        // [상속 + 다형성 + 오버라이딩] => 인터페이스 (자바의 꽃)

        AAA ref1 = new AAA();
        ref1.a1 = 10;
        BBB ref2 = new BBB();
        ref2.b1 = 5;
        ref2.testA();
        CCC ref3 = new CCC();
        ref3.a1=0;
    }
}

// 상속
class AAA {
    int a1;
    int a2;
    void testA(){}
}

class BBB extends AAA {
    int b1;
    int b2;
    
}

class CCC extends BBB{

}