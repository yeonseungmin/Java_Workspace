package p3;

public class App {
    public static void main(String[] args) {
        AAA aaa = null;
        aaa.test();

        AAA aaa2 = new AAA(){
            public void test(){
                System.out.println("하");
            }
        };

        AAA aaa3 = () -> System.out.println("하이");
        aaa3.test();
    }
}

//익명 개체 - 사실상 람다식으로 대체
interface AAA {
    public void test();
}

class Some implements AAA{
    public void test(){
        System.out.println("쿠앙");
    }
}
