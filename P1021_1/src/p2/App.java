package p2;

public class App {
    public static void main(String[] args) {
        // 자바 문법의 interface = 클래스간에 상호작용하기 위한 표준 정의
        
        // 입출력 담당 .. 코드
        int valueA = 40;
        int valueB = 20;
        Calculator calculator = new CalculatorImpl();
        int result = calculator.sum(valueA,valueB);
        System.out.println(result);
    }
}

interface Calculator{
    public int sum(int a, int b);
}

class CalculatorMock implements Calculator{ // 목업 기술
    public int sum(int a, int b){           // 협업의 기술
        return 70;                          // 가짜 클래스
    }
    
}

class CalculatorImpl implements Calculator{
    public int sum(int a, int b){
        int sum =0;
        for (int i=a; i<=b; i++){
            sum += i;
        }
        return sum;
    }
}