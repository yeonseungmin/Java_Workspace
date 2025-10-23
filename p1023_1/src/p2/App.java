package p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String str1 = new String(); //legercy 문법
        
        //Object  : 자체 의미는 없지만 중요한 클래스 명!
        // 추상화 레벨이 최상급이라 사용가능한 스태틱 인스턴스 메서드가 많이 포함되어있다.
        // 모든 클래스의 최상의 부모
        // 자료 구조 활용때 빛을 발함 *************************
        Object a1 = new Scanner("");
        Object a2 = new String();
        List<Object> list = new ArrayList<>();

    }
}

class AAA extends Object{   // ==  class AAA
    int a;
    int b;
    public String toString(){
        return String.format("{a=%d,b=%d}", a,b);
    }
}
    