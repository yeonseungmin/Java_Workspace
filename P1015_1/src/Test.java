public class Test {

    public int solution(int left, int right) {
        int answer = 0;
        int num=0;
        for(int i =left; i<=right; i++){
            for(int j =1; j<right; j++){
                if(i%j == 0){
                    num += 1;
                }
            }
            if(num%2 == 0){
                answer += num;
            }
            else{
                answer -= num;
            }
        
        return answer;
    }
    }
}


