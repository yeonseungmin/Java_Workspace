package p11;

public class App {
    public static void main(String[] args) {
        final int a =10;    //값 변동을 못시킨다 변수 > 상수
        //a = 20;

        System.out.println(Math.PI);    // final 상수 명명법 모두 대문자
    }
}

class Test{
    public final static String NAME  = "ddd";
}