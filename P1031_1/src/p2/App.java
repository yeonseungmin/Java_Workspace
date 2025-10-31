package p2;

public class App {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.setPriority(Test1.MIN_PRIORITY); //우선순위
        t1.start();

        Test2 t2 = new Test2();
        t2.setPriority(Test2.MAX_PRIORITY); //우선순위
        t2.start();
    }
}
class Test1 extends Thread {
        @Override
        public void run(){
            
            for (int i =0; i<100; i++){
            System.out.println("동훈"+i+"__");
               
        }
        }
}
class Test2 extends Thread{
    @Override
    public void run(){
        for (int i =0; i<100; i++){
            System.out.println("태호"+i);
            
        }
    }
}