import java.util.*;
public class Q10 {
    public static void main(String[] args) {
        //https://atcoder.jp/contests/abc247/tasks/abc247_b

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String[] firstNames = new String[number];
        String[] secondNames = new String[number];
        boolean sameName = false;

        for(int i =0; i<number; i++){
            String input = scanner.nextLine();
            String[] splitValues = input.split(" ");
            firstNames[i] = splitValues[0];
            secondNames[i] = splitValues[1];
        }
        for(int x=0; x<firstNames.length; x++){
            for(int y= 0; y<secondNames.length; y++){
                if(x == y ) continue;
                if(firstNames[x].equals(secondNames[y])){
                    sameName = true;
                    break;
                }else if(firstNames[x].equals(firstNames[y]) && secondNames[x].equals(secondNames[y])){
                    sameName =true;
                    break;
                }
            }
        }
        if(sameName == true){System.out.println("No");}
        else if(sameName == false){System.out.println("Yes");}
        else{System.out.println("오류");}

    }
}
 