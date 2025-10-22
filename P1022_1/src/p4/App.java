package p4;

public class App {
    public static void main(String[] args) {
        // 람다식 - 함수형 프로그래밍 기법 주요 문법
        // 가독성을 높이고 간결하게 사용하자
        // 사용조건 : 하나의 추상 메서드가 있는 Interface
        AAA a2 = (a,b) -> {
            return a+b;
         };

        AAA a1 = (a,b) -> a+b;
        
        int result = a1.test(10,20);
    }
}

//조건 1
interface AAA {
    public int test(int a, int b);
}

class AAAImpl implements AAA{
    public int test(int a, int b){
        return a+b;
    }
}
