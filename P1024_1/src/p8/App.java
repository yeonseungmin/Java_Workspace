package p8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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
    @HelloWorld(qwer=3,name = "a")
    public void test(){}
    @HelloWorld(qwer=5,name = "b")
    public void test1(){}


    //어노테이션 문법 : @ 정의 부분은 신경안써도됨, 설명을 위한 문법(주석과 같음)
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface HelloWorld{
        int qwer() default 0;
        String name() default "야호";
    }
}