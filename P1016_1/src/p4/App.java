package p4;

public class App {
    public static void main(String[] args) {
        Test t1 =new Test();
        t1.test1();
    }
}

class Test{
    public static int a;
    private int b;

    public void test1(AAA a){}

    public void test1(){}
    private static void test2(){}
}

class AAA {

    BBB b = new BBB();
    CCC c;
    public void aaa(){
        BBB b = new BBB();
    }
}

class BBB{}

class CCC{}