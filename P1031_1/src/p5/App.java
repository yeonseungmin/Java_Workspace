package p5;

import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) throws Exception{
        CompletableFuture.runAsync(SomeClass::test);    // 비동기  API
        SomeClass.test();
        

        Thread.sleep(3000);
        System.out.println("종료");
    }
}

class SomeClass{
    public static void test(){
        for (int i=0; i<100; i++){
            System.out.println("야호"+i);
            }
    }
}