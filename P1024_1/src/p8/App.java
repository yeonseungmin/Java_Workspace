package p8;

import java.time.LocalDateTime;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        //Date 말고 LocalDate를 사용하자
        Date date = new Date();
        new AAA().test();
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        LocalDateTime when = LocalDateTime.of(2024,5,3,0,0,0);
        System.out.println(when);
    }
}

class AAA{
    /*
     * 동훈햄 
     */
    public void test(){

    }
}