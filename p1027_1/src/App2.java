import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class App2 {
    public static void main(String[] args) {
        int N =5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Solution s1 = new Solution();
        System.out.println(s1.solution(N,stages));
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        double totalChellenger;
        int[] test = new int[N+2];
        double[] result = new double[stages.length];
        totalChellenger = test.length;

        for(int i =0; i<stages.length; i++){
            test[stages[i]] += 1;  
        }

        for(int i =0; i<test.length; i++){        
            if(test[i] != 0){
                result[i]=test[i]/(totalChellenger+1);
                totalChellenger -= test[i];
            }
        }
        Arrays.sort(stageArr, (a, b) -> {
        if (failRate[b - 1] == failRate[a - 1])
            return a - b; // 같은 실패율이면 번호 낮은 게 먼저
        else
            return Double.compare(failRate[b - 1], failRate[a - 1]); // 실패율 내림차순
            });
        
        return answer;
    }
}