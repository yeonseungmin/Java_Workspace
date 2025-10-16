package p2;

public class App {
    public static void main(String[] args) {
      // 클래스 설계 원칙
      // 캡슐화(정보의 은닉), 응집도를 높힌다. 결합도를 낮춘다.  

      // SOLID
      // SRP - 단일 책임 원칙
      // 하나의 클래스는 하나의 역할만 해야하고, 하나의 메서드는 하나의 기능만해야한다.
      // 하나의 매서드는 3줄 이상이면 의심해야한다.
      SumCalculator sumCalculator = new SumCalculator();
      sumCalculator.showResult();
    }
}

class SumCalculator{
private int sum;

    private int calculate(){
        int sum =0;
        for(int i =1; i<=10; i++){
            if(!(isMultipleOfThree(i))){
                sum +=i;
            }
            
        }
        return sum;
    }

    public void showResult(){
        int result = calculate();
        printResult(result);
    }

    private void printResult(int result){
        System.out.println("결과 : " + result);
    }

    private boolean isMultipleOfThree(int number){
        return number %3 ==0;
    }
}