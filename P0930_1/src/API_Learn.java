import java.util.Scanner;


public class API_Learn {
    public static void main(String[] args) {
        // API  
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 테스트 > ");
        String inputValue = scanner.nextLine(); //입력은 문자로만 받을수 있다.
        System.out.println("프로그램 종료");
        System.out.println("입력하신 값은 [" + inputValue + "] 입니다.");

        int age = Integer.parseInt(inputValue); // 문자 > 숫자      *****
        if(age<20){
            System.out.println("성인 X");
        } else {
            System.out.println("성인 O");
        }
    }
}
