package p5;

public class App {
    public static void main(String[] args) {
        int result = new SumCalcurater().sum(10, 9);
        System.out.println(result);
    }
}
class SumCalcurater{
    public int sum(int a, int b){
    int sum =0;
    if( b<a){
        throw new RuntimeException("b는 a 보다 클수없어");
    }
    for(int i=a; i<=b; i++){
        sum+=i;
        }  
    return sum;

    }
}
