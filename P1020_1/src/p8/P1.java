package p8;

public class P1 {
    public static void main(String[] args) {
        AAA a1 = new BBB(); // 상속 관계에 한해서 타입 매치 가능
                            // 다형성 ... 특정 타입(AAA)의 변수는 .. 
                            // 특정타입(AAA)를 상속받는 모든 형태의 타입을 변수로 받을 수 있다.     
                            // BBB 의 생성자로 메로리는 4개가 생성되지만 참조타입이 AAA 인 a1,a2 변수만 사용가능   
        
    }
}

class AAA{
    int a1;
    int a2;
}

class BBB extends AAA{
    int b1;
    int b2;
    void testB(){

    }
}
