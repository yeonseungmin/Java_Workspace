package p6;

public class App {
    public static void main(String[] args) throws SumCalcuraterException{
        // Exception(Checked 예외), RuntimeException(unChecked 예외)
        new Test().test();
    }
}

class Test{
    public void test()throws SumCalcuraterException{
        new SumCalcurater().sum(0, 10); //책임 회피를 받으면 호출하는 곳에서 try catch문을 잡아줘야함
    }
}

class SumCalcurater{
    public int sum(int a, int b)throws SumCalcuraterException{//throws SumCalcuraterException 로 checked를 책임회피
    int sum =0;
    if( b<a){               // Exception(Checked 예외), RuntimeException(unChecked 예외)
        throw new SumCalcuraterException();    //throw 는 exception클래스를 상속받는 클래스 checked 는 try chatch를 잡야줘야함
    }
    for(int i=a; i<=b; i++){
        sum+=i;
        }  
    return sum;
    }
}

class SumCalcuraterException extends Exception{

}