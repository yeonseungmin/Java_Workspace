package p4;

public class App {
    public static void main(String[] args) throws Exception {
        long time = System.currentTimeMillis();

        SumThread s1 =new SumThread(0 , 250000000);
        SumThread s2 = new SumThread(250000000, 500000000);
        SumThread s3 = new SumThread(500000000, 750000000);
        SumThread s4 = new SumThread(750000000, 1000000000);
        s1.start();
        s2.start();
        s3.start();
        s4.start();

        s1.join();
        s2.join();
        s3.join();
        s4.join();

        long sum = s1.getSum() + s2.getSum() + s3.getSum() + s4.getSum();
        System.out.println(sum);
        System.out.println("총 시간" + (System.currentTimeMillis() - time )+ "ms");
    }

}
class SumThread extends Thread{
    private long start;
    private long end;
    private long sum =0;
    public SumThread (long start, long end){
        this.start =start;
        this.end = end;
    }

    public long getSum(){
        return sum;
    }
    @Override
    public void run(){
        
        for(long i =start; i <=end; i++){
            sum += i;
        }
    }
}