package p8;

public class q {
    public static void main(String[] args) {
        int n = 45;
        int answer = 0;
        int count =0;
        int[] num = new int[5];
        int[] num2 = new int[5];
        while (true){
            if(n/3 > 3){
                num[count] = n%3;
                n /=3;
                count ++;
            }else{
                num[count] = n;
                break;
            }
        for(int i =num.length; i<=0; i--){
            int j=0;
            num2[j] = num[i];
            j++;
        }
        for(int i=0; i<num2.length; i++){
            answer += num2[i]*Math.pow(3,i);
        }
        }
        System.out.println(answer);
    }

}