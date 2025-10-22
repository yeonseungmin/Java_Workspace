package p6;

public class App {
    public static void main(String[] args) {
        QQQ qqq1 = a -> Math.sqrt(a);
        
        double result = qqq1.calculate(10);
    }
}

interface QQQ{
    public double calculate(int a);
}
