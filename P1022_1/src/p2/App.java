package p2;

public class App {
    public static void main(String[] args) {
    // StudentDto s1 = new StudentDto("한조",30,80);   // V.1
    // StudentDto s2 = new StudentDto();           // V.2 가독성
    // s2.setName("한조");
    // s2.setage(30);
    // s2.setScore(99); 
        
    }
}
// @Builder 로 쉽게 바뀜
class StudentDto{
    private String name;
    private int age;
    private int score;
    private StudentDto(){}  //요즘 트랜드 생성자를 막는다.********
    
    //Builder Pattern   (디자인 패턴 중 하나)
    public static class Builder{
        private String name;
        private int age;
        private int score;

        public Builder(){

        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder score(int score){
            this.score = score;
            return this;
        }
    }
    // public StudentDto(String name, int age, int score){
    //     this.name =name;
    //     this.age =age;
    //     this.score = score;

    // }
    // public StudentDto(){

    // }

    // public void setName(String name){
    //     this.name = name;
    // }
    
    // public void setage(int age){
    //     this.age = age;
    // }
    
    // public void setScore(int score){
    //     this.score = score;
    // }
}
