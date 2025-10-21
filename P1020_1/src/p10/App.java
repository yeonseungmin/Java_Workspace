package p10;

public class App {
    public static void main(String[] args) {
        // 유닛은 탱크, scv, 마린
        // 모든 유닛은 이동, 공격, 멈추기 기능
        // 각 유닛마다 가진 고유의 알고리즘이 있다.
        // 유닛의 종류와 상관없이 12개의 유닛을 부대지정해 한번에 명령가능
        Unit[] unitList = new Unit[6];
        unitList[0] = new Marine();
        unitList[1] = new Marine();
        unitList[2] = new Tank();
        unitList[3] = new Scv();
        unitList[4] = new Marine();
        unitList[5] = new Marine();

        //아래가 핵심 상속 - 다형성 - 오버라이딩 포함
        for(Unit unit : unitList){
            unit.move();
        }
        for(Unit unit : unitList){
            unit.attack();
        }
        for(Unit unit : unitList){
            unit.stop();
        }

    }
}
// 유닛은 개념
abstract class Unit{     // 추상클래스 다른 클래스에 상속을 위한 클래스
    int hp;
    int ap;
    int speed;

    abstract void move();
        // System.out.println(speed +" 만큼 이동");
    
    void attack(){
        System.out.println(speed +" 만큼 공격");
    }
    
    final  void stop(){
        System.out.println(speed +" 멈춤");
    }
}

class Tank extends Unit{
    Tank(){
    this.hp = 100;
    this.ap = 20;
    this.speed = 5;
    }
    void move(){
        System.out.println("탱크의 움직임");
    }
    void attack(){
        System.out.println("탱크의 공격");
    }

}

class Scv extends Unit{
    Scv(){
    this.hp = 30;
    this.ap = 1;
    this.speed = 1;
    }
        void move(){
        System.out.println("SCV의 움직임");
    }
    void attack(){
        System.out.println("SCV의 공격");
    }    
}

class Marine extends Unit{
    Marine(){
    this.hp = 50;
    this.ap = 50;
    this.speed = 3;
    } 
        void move(){
        System.out.println("마린의 움직임");
    }
    void attack(){
        System.out.println("마린의 공격");
    }
}