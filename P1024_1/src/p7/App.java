package p7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        // 각 데이터간 변환
        // 문자 <-> 숫자
        // 숫자 <-> 날짜
        // 날짜 <-> 문자

        // 숫자 -> 문자
        {
            int a = 10;
            String result = a+"";
            String result2 = String.valueOf(a);
            String result3 = Integer.toString(a);
        }

        // 문자 -> 숫자
        {
            String value = "27";
            int result = Integer.parseInt(value); 
        }

        // 숫자 -> 날짜
        {
            int value = 912833;
            Date result = new Date(value);
        }

        // 날짜 -> 숫자
        {
            Date value = new Date();
            long result = value.getTime();
        }

        // 문자 -> 날짜
        {
            String value = "2025-10-03";
            String value2 = value.replace("-", "/");
            // SimpleDateFormat sdf = new SimpleDateFormat("2025-10-03");
            // Date result2 =sdf.parse(value);
            Date result = new Date(value2);
            System.out.println(result);
            
        }
        // 날짜 -> 문자
        {
            Date value = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
            String result = sdf.format(value);
            System.out.println(result);
        }


    }
}
