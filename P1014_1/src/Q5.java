public class Q5 {
    public static void main(String[] args) {
        Student3 s1 = new Student3("철수");
        Student3 s2 = new Student3("영희");

        s1.study(3);
        s1.study(2);
        s1.study(1);
        
        s2.study(1);
        s2.study(1);
        s2.study(5);

        s1.printResult();
        s2.printResult();

    }
}

class Student3{
    String name;
    int totalTime;
    int score;

    Student3(String name){
        this.name = name;
    }

    void study(int hour){
        this.totalTime += hour;
        this.score += hour*3;
        
    }
    void printResult(){
        System.out.println(this.name + "의 점수는" + this.score + "입니다.");
    }
}