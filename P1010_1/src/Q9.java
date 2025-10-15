import java.util.*;
public class Q9 {
    public static void main(String[] args) {
        //https://atcoder.jp/contests/abc249/tasks/abc249_b

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        int countUp = 0;
        int countLower = 0;
        int countEqual = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]>='A' && arr[i] <= 'Z'){
                countUp ++;
            }
            if(arr[i]>='a' && arr[i] <= 'z'){
                countLower ++;
            }
        }
        for(int x = 0; x<arr.length-1; x++){
            for(int y =x+1; y<arr.length; y++){
                if(arr[x] == arr[y]){
                    countEqual++;
                }
            }
        }
        if(countUp >= 1 && countLower >= 1 && countEqual ==0){
            System.out.println("Yes");
            System.out.println(countUp + "test");
            System.out.println(countLower);
            System.out.println(countEqual);
        }else{
            System.out.println("No");
            System.out.println(countUp + "test");
            System.out.println(countLower);
            System.out.println(countEqual);
        }
    }
}

