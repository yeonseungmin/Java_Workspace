package p5;

import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) throws Exception{
        CompletableFuture.runAsync(SomeClass::test)
            .thenRun(()->{System.out.println("비동기 완료");});    // 비동기  API
        
        CompletableFuture.supplyAsync(()->{
            int sum =0;
            for( int i =0; i<100; i++){
                sum +=i;
            }
            return sum;
        }).thenAccept(result -> {
            System.out.println("결과"+ result);
        });
        

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