import java.util.*;
public class Q8 {
    public static void main(String[] args) {
        //https://atcoder.jp/contests/abc232/tasks/abc232_a
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char a = str.charAt(0);
        char b = str.charAt(2);
        
        int result = (a - '0')*(b-'0');
        System.out.println(result);
    }
}
