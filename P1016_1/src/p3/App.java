package p3;

public class App {
    public static void main(String[] args) {
        SomeComponent sc = SomeComponent.getInstance();
        sc.func();
        SomeComponent sc1 = SomeComponent.getInstance();    // 같은 생성자
    }
}

// 싱글톤
// Component = 기능 위주의 클래스 .. 대부분 한번만 생성 > 재활용
// Dto, Vo = 데이터 구조의 클래스 .. 많이 자주 상생됨
class SomeComponent{        // 생성패턴 - 생성자를 한번만 사용하게끔 하는 문법
                            // 싱글톤패턴

    
    private static SomeComponent instance = null;  //2. static 으로 변수에 null 값 
    // private static final SomeComponent instance = new SomeComponent();   // 최신 코드 법.
    public static SomeComponent getInstance(){      //3. public으로 Api제공
        if(instance == null){
            instance = new SomeComponent();

        }
        return instance;
    }

    private SomeComponent(){    // 1. 생성자를 private로 막음

    }
// -----------------------------------------------------------------------------
    //실제 기능
    public void func(){
        System.out.println("기능이 실행됩니다.");
    }

}
