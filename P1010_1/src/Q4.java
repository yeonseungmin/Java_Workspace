import java.util.*;
public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] firstNames = new String[N];
        String[] secondNames = new String[N];

        for(int i =0; i<N; i++){        //반복문의 입력은 배열로 관리
            String value1 = scanner.nextLine();
            String[] splitValues = value1.split(" ");
            firstNames[i] = splitValues[0];
            secondNames[i] = splitValues[1];
        }
        


    }
}
