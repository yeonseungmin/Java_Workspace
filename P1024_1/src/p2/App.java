package p2;

public class App {
    public static void main(String[] args) {
        //String..불변객체.. 값을변경시키는 메서드,연산자 사용시 새로운 메로리를 만들어 리턴
        //String + 연산이 많이 발생할시 효율이 떨어지므로 StringBuilder,StringBuffer을 사용
        //StringBuffer, StringBuilder : 가변 객체( 기초질문 유형 ) 쓰레드 안정성 차이
        //Buffer : 여유 값 ,
        //속도 체크 API : System.currentTimeMillis();

        long time = System.currentTimeMillis(); // 1970년 1월 1일 0시 0분 0초 000ms부터 지금까지
        System.out.println(time/1000/60/60/24/365);   //1761268859533 


        StringBuilder stringBuilder = new StringBuilder("안녕");
        StringBuffer stringBuffer = new StringBuffer();

        String text = "안녕하세요";
        text.substring(3);  // 3번째 부터 짤라 그 값을 새로 만들어 리턴
        for(int i=0; i<10000; i++){
            stringBuilder.append("호야");     //내부에 넉넉한 배열을 만들어서 올림;
        }
        String resultText = stringBuilder.toString();
        System.out.println(resultText);
        
        System.out.println("첫번째: " +(System.currentTimeMillis()-time + "ms"));

        String text2 = "";

        for(int i=0; i<10; i++){
            text2 += "야호";     //메모리 계속 생성해서 리턴
        }
        System.out.println(text2);


    }
}
