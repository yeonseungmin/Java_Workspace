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
        for(double e : result){
            System.out.println(e);
        }
        
        return answer;
    }
}