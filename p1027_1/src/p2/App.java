package p2;

public class App {
    public static void main(String[] args) {
        // 예외 처리 !!! - 프로그램의 안정성 확보
        //기능이 구현 가능한 상태 후 처리

        System.out.println("프로그램 시작");

        int a = 10;
        int b =0;
        
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e){
            System.out.println("계산오류");
        } catch (NullPointerException e ){
            System.out.println("널포인트");
        }

        
        System.out.println("프로그램 끝");      // try catch 문으로 오류를 예외처리하여 프로그램 끝가지 진행
    }
}
