package p2;

public class App {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.plus(0,0);
        t1.plus(0,0);
        t1.plus(0,0);
    }
}

class Test{
    int a;
    int b;

    
    int plus(int c, int d) {    // 타인이 쓰게 하려고 만듬(메서드)
        if( a<0) return -1;

        int result = this.a+this.b+c+d;
        return result;
    }
}