package p1;

public class App {
    public static void main(String[] args) {
        int a = 10; //한번 실행에 10분이 걸린다는 가정
                    //세번 실행 시킨다면 독립적으로 실행 할것이다.
                    // 동기식 으로 실행시킨다면 총 30분;
                    // 비동기 식이라면 프로그램 스펙에 따라 달라짐 
                    // 프로세스는 독립적으로 실행, 메모리를 공유하지 않느다.
                    // BUT 하나의 프로세스에 여러개의 흐름을 만들수 있따 >> Threads
         
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();

        test1.start();  // 비동기 명령어
        test2.start();
        new Thread(new Test3()).start();
        // new Thread(() ->{
        //     for (int i =0; i<100; i++){
        //     System.out.println("test4"+i);
        //     }
        // }).start();
        new Thread(App::print).start();

        System.out.println("===========================");


    }
    public static void print(){
    for (int i =0; i<100; i++){
        System.out.println("test4 "+i);
    }
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

class Test3 implements Runnable {
    @Override
    public void run(){
        for (int i =0; i<100; i++){
            System.out.println("test3 "+i);
        }
    }
}
