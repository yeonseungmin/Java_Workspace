public class App2 {
    public static void main(String[] args) {
        int N =5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        Solution s1 = new Solution();
        s1.solution(N,stages);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int count =1;
        int[] test = new int[N];
        for(int i =0; i<stages.length; i++){
            test[stages[i]] += 1;  
        }
        

        for(int e : test){
            System.out.println(e);
        }
        return answer;
    }
}