package p3;

public class App {
    public static void main(String[] args) throws Exception{
        // 비동기 코드 작성시 주의사항
        // 상당수는 데이터를 공유하지 않음 -> 편하게 비동기 코드 작성해도됨
        // 여러 쓰레드(비동기 코드가) 메모리를 공유하면 많이힘들어짐.. 동기화 필수
        // 비동기 코드를 동기화 하면  할수록 .. 왜 비동기로 만들었는지 의문이 들 수밖에 없다.
        // 동기화 필요시 최소한으로 하는것이 좋다.
        Test t1 = new Test();
        t1.start();
        Test t2 = new Test();
        t2.start();
        
        t1.join();  //join 동기화 매서드 - t1 쓰레드가 끝날 때까지 기달임
        t2.join();

        System.out.println(Data.count);
    }
}
class Test extends Thread{
    @Override
    public void run(){
        for(int i =0; i< 100; i++){
            Data.increaseCount();
        }
    }
}

class Data{
    public static int count =0;
    public synchronized static void increaseCount(){    // synchronized 먼저 실행한 쓰레드가 완료될때 까지 보장해준다.: 동기화
        int temp = count;                               // 동기화 = 병목
        //System.out.println("어떤 코드");  //일부러 오버해드 발생 목적
        temp++;
        count = temp;
    } 
}