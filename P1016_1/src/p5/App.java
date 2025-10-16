package p5;

public class App {
    public static void main(String[] args) {
        Car car1 = new Car();
        Person person1 = new Person(car1);

        person1.setCar(car1);

        Person person2 = new Person();
        person2.setCar(car1);
    }
}

class Person{
    Eye leftEye = new Eye();
    Eye rigEye = new Eye();
    Car car;
    
    Person(Car car){    // DI = 의존 주입 코드 (생성자 주입)
        this.car = car;
    }
    void setCar(Car car){   //DI = 의존 주입 코드 (setter 주입)
        this.car = car;
    }
}

class Eye{

}

class Car {

    
}