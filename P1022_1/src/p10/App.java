package p10;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        //API
        // 1~ 100 중 3의 배수 제외하고 합
        int sum = IntStream.rangeClosed(1, 100)
            .filter(x->x%3!=0)
            .sum();
        ;
        System.out.println(sum);
        
    }
}
