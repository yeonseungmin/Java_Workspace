package p8;


public class App {
    public static void main(String[] args) {
        Account a1 = new Account("철수");

        a1.deposit(3000);
        a1.deposit(3000);
        a1.withdraw(100000);
        // a1.balance += 3000;
        // a1.balance += 3000;
        // a1.balance -= 5000;

        System.out.println(a1.getOwner() + "의 잔액 : " +a1.getBalance());


    }
}

class Account{
    //속성 - 가장중요한값 접근 제한자 설정 중요!
    private String owner;
    private int balance;
    
    public Account(String owner){
        this.owner = owner;
    }

    public void deposit(int value){
        this.balance += value;
    }

    public void withdraw(int value){
        if(canNotWithdraw(value)){
            System.out.println("잔액 부족");
            return;
        }

        balance -= value;
    }

    // Read Onyl 메소드
    public String getOwner(){
        return owner;
    }

    public int getBalance(){
        return balance;
    }

    private boolean canNotWithdraw(int value){
        return balance < value;
    }

}