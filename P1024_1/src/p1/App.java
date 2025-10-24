package p1;

public class App {
    public static void main(String[] args) {
        //Wrapper 클래스
        Integer.parseInt("12");
        //Binary
        String a = Integer.toBinaryString(2);
        String b =Integer.toHexString(16);
        System.out.println(a);
        System.out.println(b);

        String result = 10 + " ";               // 숫자 -> 문자 바꾸는 API
        String result2 = String.valueOf(10);    // 가독성이 좋음
        String result3 = Integer.toString(10);

        int c = Integer.bitCount(9);    // 8비트 기준으로 1 넘어갈 때 마다 +1
        System.out.println(c);

    }
}
