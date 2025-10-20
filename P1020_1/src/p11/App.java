package p11;

public class App {
    public static void main(String[] args) {
        
        AAA aaa = new QWER();
        aaa.foo();

    }
}

// Interface 인터페이스
interface AAA { //변수 선언 가능 , 인스턴스 메모리 생성 불가 , [public , abstract 필수(생략된것)]*********************
    public abstract void test(); // {} 없음
    void test1();   //[public abstract 생략된것(존재 O)]
    public void foo();

    public static final int a= 0;
    int b = 0;      // [ public static final 생략된것 ]

    default void yyyy(){
        System.out.println("fffff");
    }
}

class  QWER implements AAA{     //모든 메소드를 똑같이 구현해줘야 함.
    public void test(){}
    public void test1(){}
    public void foo(){} 
}