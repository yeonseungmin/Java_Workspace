package p3;

public class App {
    public static void main(String[] args) {
        Team[] teams = new Team[5];
    }
}

//조직도
class Team{
    String name;
    // .. 기타 정보들
    Team[] teams = new Team[5];     // 자료구조상 재귀
    Person[] persons = new Person[5];
}

class Person{
    String name;
    // .. 기타 정보들
}