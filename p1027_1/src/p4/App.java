package p4;

public class App {
    public static void main(String[] args) {
        new Controller().controllerMethod();
        System.out.println("프로그램 종료");
    }
}

class Controller{
    public void controllerMethod(){
        try {
            new Service().serviceMethod();    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
        
    }
}


class Service{
    public void serviceMethod(){
        
    try {
            new Repository().repositoryMethod();
        } catch (Exception e) {
            e.printStackTrace();
            
        }finally{
            // 그 어떠한경우에도 실행됨 
        }
        System.out.println("어떤한 경우에도 실행");
    }
    
}

class Repository{
    public void repositoryMethod(){
        int result = 10/0;
        System.out.println(result);
    }
}