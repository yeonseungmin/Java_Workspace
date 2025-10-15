import java.util.*;
public class Q6 {
    public static void main(String[] args) {
//https://atcoder.jp/contests/abc243/tasks/abc243_a

// A - 샴푸

// 문제 설명
// 다카하시의 집에는 다카하시, 그의 아버지, 그의 어머니, 이렇게 3명이 살고 있다. 그들 모두는 매일 밤 화장실에서 머리를 감는다.
// 아버지, 어머니, 다카하시의 차례로 목욕을 하고, 각각 A, B, C 밀리리터의 샴푸를 사용한다.

// 오늘 아침, 그 병에는 V 밀리리터의 샴푸가 들어있었다. 리필하지 않고, 머리를 감을 샴푸가 가장 먼저 부족하게 될 사람은 누구인가?

// 제약
// 1 ≤ V, A, B, C ≤ 10^5
// 모든 입력값은 정수이다.

// 입력
// 입력은 다음 형식의 표준입력으로 제공된다.
// V A B C

// 출력
// 머리를 감을 샴푸가 가장 먼저 부족하게 될 사람이 다카하시의 아버지라면 F를, 다카하시의 어머니라면 M을, 다카하시라면 T를 인쇄한다.

        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();        
        int[] arr = {a,b,c};
        while(true){
            if(v < a){
                System.out.println("F");
                break;
            }
            v-=a;
            if(v < b){
                System.out.println("M");
                break;
            }
            v-=b;
            if(v < c){
                System.out.println("T");
                break;
            }
            v-=c;

        }

    }

}
