public class P4 {
    public static void main(String[] args) {
        //  3항 연산자
        int score = 78;
        String result="";

        if(score >= 60){
            result="합격";
        }else {
            result="불합격";
        }
        System.out.println(result);
    }
    {
        int score =78;
        String result = score >= 60 ? "합격" : "불합격"; //3항 연산자 ? 이후 타입 통일
    }
        {
        int score =78;
        String result = score >= 60 ? "합격" :score >= 50 ? "재시험" : "불합격"; //도 가능하긴하다.. 타임이 일정하기 때문
    }
    {
        int a = 10;
        int b = 20;

        if (a == b){
            //
        }

        String s1 = "안녕하세요";
        String s2 = "안녕하세요";
        if (s1 == s2){  // 문자열 비교는 이런식으로 하지마라!
            //
        }    

        if (s1.equals(s2)){  // 문자열 비교는 이런식으로 .equals() 사용 API !!!!!!!!!
            //
        }            

    }
}
