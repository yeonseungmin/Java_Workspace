package p4;

public class q {
    public static void main(String[] args) {
        //정규 표현식 - 대부분의 언어 ,, 데이터베이스에서 지원함
        //문자를 .. 틀수한 형태로 판별하는 문법

        String accountName = "뷁똵뚫";
        if (accountName.equals("qwer@qqqq.com")){

        }
        String test = "[a-zA-Z0-9가-힣ㄱ-ㅎ\\]]{3,}{0-9{2}}";// []로 시작  // 한글자만
        String test2 = "\\d{3}";
        String test3 = "[a-z]+[0-9]";   // aaaaaa0 O, aaaaaa00 X
        String test4 = "^Java[a-z]*"; // JAVA로 시작해야함
        String test5 = "[a-z]+JAVA$";   // JAVA 로 끝나야함
        if(accountName.matches(test)){
            System.out.println("패턴에부합");
        }else{
            System.out.println("패턴에 부합 X");
        }
    }
}
