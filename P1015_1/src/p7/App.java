package p7;

public class App {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.a = 10;
        t1.qqqq(10);
        
    }
}

// 접근 제한자
class Test{
    public int a;   //중요
    protected int b;
    int c;
    private int d;  //중요

    public void qqqq(int num){
        a =10;
        d =10 + num;
    }

}