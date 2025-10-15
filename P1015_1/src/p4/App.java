package p4;

public class App {
    public static void main(String[] args) {
        SumCalc1 sc1 = new SumCalc1();
        int result1 = sc1.sum(1,10);

        SumCalc2 sc2 = new SumCalc2(1, 10);         // 다회성
        int result = sc2.getResult();

        int result3 = new SumCalc2(1,10).getResult();   // 일회성


    }
}


class SumCalc1{
    int sum(int s, int e){
        int sum =0;
        for (int i= s; i<=e; i++){
            sum += i;
            
        }
        return sum;
    }
    
}

class SumCalc2{
    int sum =0;
    int start =0;
    int end =0;

    SumCalc2(int start, int end){
        for(int i =start; i <= end; i++){
            sum += i;

        }
    }

    int getResult(){
        return sum;
    }
}