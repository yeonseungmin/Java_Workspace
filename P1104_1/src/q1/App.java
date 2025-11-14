package q1;

public class App {
    public static void main(String[] args) {
        int N =5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Solution s1 = new Solution();
        s1.solution(N, stages);

    }
}

class Solution {
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] test = new int[N+1];
        int[] result = new int[N+1];
        int count = stages.length;
        int value =0;
        // 스테이지별 사용자 수
        for(int i =0; i<stages.length; i++){
            test[stages[i]-1] += 1;  
        }
        for(int i =0; i<N+1; i++){
            
            if(test[i]==0){
                continue;
            }
            if(test[i] != 0){
                if (count == 1){
                    result[i]=test[i]/(count);
                    continue;
                }
                result[i]=test[i]*100/(count);
                count -= test[i];
            }
        }

        for(int i=0; i<result.length-1; i++){
            int cnt =0;
            int temp =0;
            if(result[i] == 0 )continue;
            for(int j=i+1; j<result.length; j++){
                if(result[i] > result[j]){
                    cnt +=1;
                    
                }
                result[cnt] = j;
            }
            
        }
        
        return result;
    }
}