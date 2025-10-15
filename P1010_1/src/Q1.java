import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        // https://atcoder.jp/contests/abc248/tasks/abc248_a

        // A - 부족한 숫자

        // 문제 설명
        // 숫자로 구성된 길이가 정확히 9인 문자열 S가 주어진다. 0부터 9까지의 모든 숫자가 S에 정확히 한 번 나타난다.
        // S에서 누락된 유일한 숫자를 인쇄하라.

        // 제약
        // S는 숫자로 구성된 길이 9의 문자열이다.
        // S의 모든 문자는 서로 다르다.

        // 입력
        // 입력은 다음 형식의 표준입력으로 제공된다.
        // S

        // 출력
        // S에서 누락된 유일한 숫자를 인쇄한다.
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); // 문자입력 받을땐 nextLine()을 쓴다.

        // char aaa = s.charAt(3);  // 문자열 인덱스 3번째 
        // for(int i =0; i< s.length(); i++){
        //     char aaa = s.charAt(3);
        // }  
        int sum =45;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            sum -= arr[i]-'0';  //문자를 숫자로 치환하는 법
        
        }
        System.out.println(sum);


        scanner.close();
    }
}
