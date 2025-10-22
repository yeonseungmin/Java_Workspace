import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        
        int[] numbers ={2,1,3,4,1};

        int[] answer = {};
        int count =0;
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length-1; i++){
            for(int j = i+1; j <= numbers.length; j++){
                if(answer[i] != numbers[i]+numbers[j]){
                    answer[count] = numbers[i]+numbers[j];
                    count ++;
                    System.out.println(answer);
                }
            }
        }
        System.out.println(answer);
    }
}

