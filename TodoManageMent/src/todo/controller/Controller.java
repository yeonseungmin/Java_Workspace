package todo.controller;

import todo.service.Service;
import todo.util.IoManager;

public class Controller {
    private Service service = new Service();
    public void run(){
        welcome();

        while(true){
            showMenu();
            String command = selectCommand();

            if(isExitCommand(command)){ // 탈출 코드
                break;
            }
            processCommand(command);
            pause();
        }
        bye();
    }
    private void welcome(){ // 1. 인사 
        IoManager.print("*******************************");
        IoManager.print("      해야 할 일 관리 프로그램     ");
        IoManager.print("           2025.10.17          ");
        IoManager.print("*******************************");
    }
    private void bye(){
        IoManager.print("프로그램이 종료됩니다.");
    }
    private void showMenu(){
            IoManager.print("[ 메뉴 ]");
            IoManager.print(" 1. 할일 등록 ");
            IoManager.print(" 2. 등록된 날짜 조회 ");
            IoManager.print(" 3. 완료 처리 ");
            IoManager.print(" 4. 미완료만 보기 ");
            IoManager.print(" 5. 완료만 보기 ");
            IoManager.print(" 6. 제목 키워드 검색 ");
            IoManager.print(" 7. 삭제 ");
            IoManager.print(" 0. 종료");
    }
    private String selectCommand(){
            String command = IoManager.input("선택 > ");
            return command;
    }
    private boolean isExitCommand(String command){
        return command.equals("0"); // 0 종료
    }
    private void processCommand(String command){
            if(command.equals("1")){
                service.addTodo();
            }else if(command.equals("2")){
                service.viewRegisterDate();
            }else if(command.equals("3")){
                service.checkTodo();
            }else if(command.equals("4")){
                service.viewOnlyCheckFalse();
            }else if(command.equals("5")){
                service.viewOnlyCheckTrue();
            }else if(command.equals("6")){
                service.findByKeyWordOfTitle();
            }else if(command.equals("7")){
                service.remove();
            }else {
                IoManager.print("잘못된 명령을 입력하셨습니다.");
                IoManager.print("다시 입력해주세요");
            }
    }
    private void pause(){
        IoManager.pause();
    }


}
