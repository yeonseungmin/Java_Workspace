package p7;
    
public class App {
    public static void main(String[] args) {
        BBB b1 = new BBB();
        System.out.println(b1.a1);
        b1.testB();

    }
}

class AAA{
    int a1 = 10;
    int a2 = 20;
    AAA(){
        System.out.println("AAA 생성자 호출됨 a1,a2의 초기화 하는 중요한 코드");
    }
    AAA(int a1){
        System.out.println("AAA 생성자 호출됨 ");
    }    
}

class BBB extends AAA{
    int a1 = 30;
    int b1 = 40;
    int b2 = 50;
    BBB(){
        super(1);
        System.out.println("BBB 생성자 호출됨 b1,b2의 초기화 하는 중요한 코드");
    }    
    void testB(){
        System.out.println(this.a1);
        System.out.println(super.a1);   // 좋은 문법은 아니다.
    }
}