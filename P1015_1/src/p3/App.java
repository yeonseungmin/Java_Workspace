package p3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        IOManager ioManager = new IOManager();
        Calculater c1 = new Calculater();
        
        String value = ioManager.input("값 입력 > ");
        System.out.println(value);
        ioManager.output("입력된 값 > "+ value);
        c1.sumStartToEnd(2,10);
        int result = c1.sumStartToEnd(1,10);
        System.out.println(result);
    }
}
class IOManager{
    // 입출력 담당
    // 속성
    Scanner scanner = new Scanner(System.in);

    String input(String text){
        System.out.print(text);
        
        String inputValue = scanner.nextLine();
        return inputValue;
    }

    void output(String text){
        System.out.println(text);

    }
}

class Calculater{
int sumStartToEnd(int start, int end){
    int sum =0;

    for(int i=start; i<=end; i++){
        sum = this.accumulate(sum, i);
    }
    //System.out.println(sum);    // 출력은 메인에서(잘못된 코드)
    return sum;
    }

    int accumulate(int sum, int i){
        sum += 1;
        return sum;
    }
}
