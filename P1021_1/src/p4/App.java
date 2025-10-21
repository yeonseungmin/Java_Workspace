package p4;

import java.util.HashMap;
import java.util.Map;

public class App {
    // 학생 관리 프로그램
    public static void main(String[] args) {
        ServiceContainer serviceContainer = new ServiceContainer();
        
        System.out.println(" 반갑습니다. ");
        while(true){
            System.out.println("메뉴");
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("0.종료");

            String command = "0";

            if(command.equals("0")) break;

            Service service = serviceContainer.getService(command);
            service.run();
        }
    }
}

interface Service{
    public void run();
}
class StudentAddService implements Service{
    public void run(){
        //학생 등록 로직..
    }
}
class StudentListService implements Service{
    public void run(){
        //학생 목록 출력 로직..
    }
}

class StudentRemoveService implements Service{
    public void run(){

    }
}
class ServiceContainer{
    private Map<String,Service> map = new HashMap<>();

    public ServiceContainer(){
        map.put("1", new StudentAddService());
        map.put("2", new StudentListService());
    }
    public Service getService(String command){
        return map.get(command);
    }
}