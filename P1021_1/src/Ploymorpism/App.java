package Ploymorpism;

public class App {
    public static void main(String[] args) {
        // 상속 다형성 오버라이딩 => 인터페이스
        // 표준을 정의하고 조립식으로 만든다.
        // DI, IoC, Container(Factory)
        BeansContainer beansContainer = new BeansContainer();
        User user = beansContainer.getUser();
        user.watchTv();
    }
}
