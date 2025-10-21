package p5;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // 하루 일과 프로그램
        Controller controller = new Controller();
        controller.run();
    }
}
class Controller{
    private ServiceContainer serviceContainer = new ServiceContainer();
    
    // private Service service = new Service();
    // private Service service;
    public void run(){
        System.out.println("하루 일과를 시작합니다.");
        // service.wakeUp();
        // service.eat();
        for(Service service: serviceContainer.getServiceList()){
            service.process();
        }
        
    }
}  

// class Service{
//     public void wakeUp(){
//         System.out.println("일어납니다.");
//     }
//     public void eat(){
//         System.out.println("밥을 먹습니다.");
//     }
// }

interface Service{
    public void process();

}
class WakeUpService implements Service{
    public void process(){
        System.out.println("일어납니다.");
    }
}
class SharWar implements Service{
    public void process(){
        System.out.println("씻습니다.");
    }
}
class DhongHunWakeUp implements Service{
    public void process(){
        System.out.println("동훈햄을 깨웁니다.");
    }
}

class ServiceContainer{
    private List<Service> list = new ArrayList<>();
    
    public ServiceContainer(){
        list.add(new WakeUpService());
        list.add(new SharWar());
        list.add(new DhongHunWakeUp());
    }
    public List<Service> getServiceList(){
        return list;
    }
}