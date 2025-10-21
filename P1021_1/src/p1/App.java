package p1;

public class App {
    public static void main(String[] args) {
        // 상속 - 다형성 - 오버라이딩 => 인터페이스
        Walkable walker = new Person();
        Walkable walker2 = new Duck();

        walker.walk();  //Person 의 walk
        walker2.walk(); //Duck 의 walk
        // walker2.fly();   문법적 오류
        Flyable walker3 = new Duck();
        walker3.fly();
        //walker3.walk();   문법적 오류
    }
}

interface Flyable{
    public void fly();  //abstract 생략
}

interface Walkable{
    public void walk();
    
}

class Person implements Walkable{
    public void walk(){
        System.out.println("사람의 로직으로 걷습니다.");
    }
}

class Duck implements Flyable, Walkable{    
//implements : 하나의 클래스는 다중 인터페이스를 구현할 수 있다.
    public void walk(){
        System.out.println("오리의 로직으로 걷습니다.");
    }
    public void fly(){
        System.out.println("오리의 로직으로 날아갑니다.");
    }
}