package p1;

public class App {
    public static void main(String[] args)throws Exception {
        new Test().qqqq();
    }
}
class Test{
    // 재귀 매서드
    // 자신을 계속 호출
    private int count =0;
    public void qqqq()throws Exception{
        Thread.sleep(100);
        count++;
        int currentCount = count;
        if(count>10){return;}
        System.out.println("qqqq 시작"+ currentCount);  // 시작 1 ~ 10
        qqqq();                                        // 재귀 매서드    
        System.out.println("qqqq 끝" + currentCount);  // 끝 10 ~ 1 
    }

}

