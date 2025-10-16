package p9;

public class App {
    public static void main(String[] args) {
        StudentDto s1 = new StudentDto();
        s1.setName("영희");
        System.out.println(s1.getName());

    }
}

 class StudentDto{
    private String name;
    private int age;
    private int score;

    // setter - write 권한
    public void setName(String name){
        this.name = name;
    }

    // getter - read 권한
    public String getName(){
        return name;
    }

        // setter - write 권한
    public void setAge(int age){
        this.age = age;
    }

    // getter - read 권한
    public int getAge(){
        return age;
    }

        // setter - write 권한
    public void setScore(int score){
        this.score = score;
    }

    // getter - read 권한
    public int getScore(){
        return score;
    }
}
