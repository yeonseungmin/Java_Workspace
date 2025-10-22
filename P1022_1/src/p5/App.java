package p5;

public class App {
    public static void main(String[] args) {
        BBB bbb = (a) -> System.out.println(a);
        bbb.test(3);
    }
}

interface BBB{
    public void test(int a);
}
