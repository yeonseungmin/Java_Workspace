import java.util.*;
public class Q7 {
    public static void main(String[] args) {
        // https://atcoder.jp/contests/abc236/tasks/abc236_a
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        

        char[] arr = str.toCharArray();
        char temp = arr[a-1];
        arr[a-1] = arr[b-1];
        arr[b-1] = temp;
        
        System.out.println(arr);
    }
}
