package p8;

public class App {
public static void main(String[] args) {
    new Some().test(()->{
        System.out.println("사용자의 알고리즘");
    });

    new Some().test(() ->{
        System.out.println("사용자의 또다른 알고리즘");
    });
}
}

interface Consumer{
    public void qqqqq();
    
}

class Some{
    public void test(Consumer aaa){

        System.out.println("test 시작 ");
        aaa.qqqqq();


        System.out.println("test 마무리 ");
    }
}
