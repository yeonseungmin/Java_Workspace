package Ploymorpism;

public class User {
    private Tv tv;  //일반적으론 이렇게 사용함 의존성 낮춤
    
    public User (Tv tv){// DI , 생성자 (의존주입)
        this.tv = tv;
    }
    // public void setTv(Tv tv){  // 세터 주입 (의존주입)
    //     this.tv = tv;
    // }

    public void watchTv(){ //파라미터를 작성함으로써 의존성을 낮춤
        // Tv tv = new SamsungTv();  // { Tv }인터페이스에 기준을 두고 설계를하겠다.
        // Tv tv2 = new LgTv();  // User 클래스가 개인적으로 삼성,엘지에 의존중  
        tv.powerOn();
        tv.volumUp();
        tv.volumDown();
        tv.powerOff();
        System.out.println(" TV 시청 종료! ");
    }
}
