package p3;

import java.util.Random;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        int value = (int)(Math.random()*100)+1;

        Random random = new Random(1000);   // 파라미터에 따라 랜덤의 시드가 결정
        int value2 = random.nextInt(100)+1;
    
        System.out.println(value2);

        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
