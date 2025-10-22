package p1;

public class App {
    public static void main(String[] args) {
        AAA2 aaa = new AAA2();
        AAA2.BBB2 bbb = aaa.new BBB2();
    }
}
class AAA{  //인너클래스 매서드 내에서 클래스 선언 가능
    public void testA(){    //중요도 하
        int a = 10;
        int b = 20;
        
        class BBB {
            public void testB(){
                System.out.println("bbbb");
            }
        }

        System.out.println("aaaa");
    }
}

class AAA2{  
    class BBB2{

    }
    static class CCC{

    }
}