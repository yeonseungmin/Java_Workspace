package p4;

public class App {
    public static void main(String[] args) {
        // 요일 .. 과 관련된 프로그램
        // 고전적으로 요일 관련은 int로 매칭 했음 월 : 1, 화 : 2, ...
        // enum 을 사용하면 가독성 좋게 사용가능하다.
        int currentDay = 1;        
        Day currentDay2 = Day.MONDAY;
        
        if(currentDay2 == Day.MONDAY){

        }else if(currentDay == (2)){

        } //....
    }
}

//enum 문법 : 도메인 정의 ( 정보의 한정된 범위 )
enum Day {
    // SUNDAY,
    // MONDAY,
    // TUESDAY,

    SUNDAY(0),
    MONDAY(1);
    private int value;

    Day(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}