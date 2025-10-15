import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Worker w1 = new Worker("철수");
        Worker w2 = new Worker("영희");

        w1.test1(); // 메서드 호출 문법
        w1.test2(3,1);
        int aaa =w1.test2(3, 4);
        System.out.println("프로그램 종료!!");
        w1.test3("바보들");
    }
}

class Worker {  // 대문자 시작 (명사)
    // 속성
    String name;
    int money;

    // 생성자
    Worker(String name){    // 대문자 시작 (명사)
        this.name = name;
    }
    // 기능 - 메서드    [ return타입 메서드명() ]
    void test1(){   // 소문자 시작 (동사)   // 메서드 정의, 메인에서 호출 필요
        System.out.println("test1 호출됨");
    }
    int test2(int a, int b){   // 소문자 시작 (동사)   // 메서드 정의, 메인에서 호출 필요
        System.out.println("test2 호출됨");
        return a+b;     // [ return타입있는 경우 내부에서 return 필수 ]
    }
    void test3(String text){
    if(text.contains("바보")){
        System.out.println(" 비속어 금지 ");
        return;

    }
}
}

