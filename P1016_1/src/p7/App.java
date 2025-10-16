package p7;

import java.util.Scanner;

public class App {
    Scanner scanner = new  Scanner(System.in);

    int a = scanner.nextInt();  // 걷는 시간
    int b = scanner.nextInt();  // 초속
    int c = scanner.nextInt();  // 휴식 시간
    int d = scanner.nextInt();  // 걷는 시간
    int e = scanner.nextInt();  // 초속
    int f = scanner.nextInt();  // 휴식 시간
    int x = scanner.nextInt();  // 종료 시간

    Runner takahashi = new Runner(b,a,c);
    Runner aoki = new Runner(e,d,f);
    Stadium stadium = new Stadium(x,takahashi,aoki);
    


}

class Runner{

    int distance=0;


    int distansPerSec;
    int runTime;
    int restTime;
    public Runner(int distansPerSec, int runTime, int restTime){    //b a c

        this.distansPerSec = distansPerSec;
        this.runTime = runTime;
        this.restTime = restTime;
    }
    public void process(){

    }
    public void run(){
        distance += distansPerSec;
        
    }
    public void rest(){

    }

}
class Stadium{
    int totalRunningTime;
    Runner takahashi;
    Runner aoki;
    public Stadium(int totalRunningTime, Runner takahashi, Runner aoki){
        this.totalRunningTime = totalRunningTime;
        this.takahashi = takahashi;
        this.aoki = aoki;
    }

    public void stadium(){
        for(int i=0; i<totalRunningTime; i++){
            takahashi.process();
            aoki.process();
        }
    }


}
