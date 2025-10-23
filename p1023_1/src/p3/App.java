package p3;

public class App {
    public static void main(String[] args) {
        // Wrapper 클래스 - 기본타입을 보조하는 클래스;
        //사용시 주의를 요함.
        // 장점 : null을 가질수 있다.
        int a = 10;
        Integer b = 20; //boxing    [20] 박스에 싸서 주소값을 주겠다.
        //b.parseInt(null)  이 된다. (참조 변수기 때문에)
        int c = b; //UnBoxing   
        Integer qq = 10;
        qq++;       // 연산은 금지된다. 바뀐 주소값에 들어있는 값을 모르기 때문에.
                    // 메모리 생성 갯수가 많아진다. 반복문은 피할것
        Byte byte1 =20;
        Short short1 = 20;
        Integer integer1 =30;
        Long long1 = 30L;
        Float float1 = 3.14f;
        Double double1 = 3.14;
        Character character = 'a';
        Boolean boolean1 = true;
                    
    }
}
