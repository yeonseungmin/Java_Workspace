package p6;

public class App {
 public static void main(String[] args) {

    Test.c=10;  // static에 접근하기 위해서는 클래스명을 사용한다.

    Test t1 = new Test();
    Test t2 = new Test();
    
    t1.a =10;
    t2.a =20;

    t1.c = 10;
    t2.c = 20;

    System.out.println(t1.c);
    System.out.println(t2.c);
 }
}

class Test{
    int a;  // 인스턴스 변수
    int b;
    static int c;   // 클래스 변수 (접근하는 순간 생성되고 소멸하지 않는다.)




}

class Ex{
    void qqq(){

    }
}