import java.util.*;
public class Q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
   
        for(int i= 1; x < 1000; i++){
            // y > x + 10*i;
             x = x + 10;
             if(x>=y){
                System.out.println(i);
                break;

             }
        }if(x>=1000){System.out.println(0);}
    }
}
