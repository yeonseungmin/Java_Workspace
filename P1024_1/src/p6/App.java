package p6;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        //날짜 - 사실상 숫자
        //Date -> LocalDate, LocalDateTime, LocalTime

        Date date = new Date(); // 현재 시간 (날짜)
        System.out.println(date);

        Date dateLegercy = new Date(0); // 현재 시간 (날짜)
        System.out.println(dateLegercy);

        System.out.println(date.getYear());
        System.out.println(date.getMonth()+1);    //대부분의 언어에서 10월은 9월이 나올것이다..************
                                                // ㄴ 미국에서 1월을 0월로 표현했을것이다....
        System.out.println(date.getDate()); //날짜
        System.out.println(date.getDay());  //요일

        

    }
}
