package com.accountbook.acb.controller;
import com.accountbook.acb.service.Service;
import com.accountbook.acb.util.IoManager;

public class Controller {
    private Service service = new Service();
    public void run(){
        welcome();
        while (true) {
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

    private void welcome(){
        IoManager.print("*********** 가계부 관리 프로그램 ***********");
        IoManager.print("                 연승민                  ");
        IoManager.print("****************************************");
    }
    private void bye(){
        IoManager.print("프로그램이 종료됩니다.");
    }

    private void showMenu(){
            IoManager.print("[ 메뉴 ]");
            IoManager.print(" 1. 가계부 등록 ");
            IoManager.print(" 2. 가계부 목록 ");
            IoManager.print(" 3. 가계부 삭제 ");
            IoManager.print(" 4. 카테고리별 합계 ");
            IoManager.print(" 5. 금액 내림차순 보기");
            IoManager.print(" 6. 메모 키워드로 검색");
            IoManager.print(" 0. 프로그램 종료  ");
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
                service.AccountBookRegister();
            }else if(command.equals("2")){
                service.ListAccountBook();
            }else if(command.equals("3")){
                service.DelAccountBook();
            }else if(command.equals("4")){
                service.SumCategory();
            }else if(command.equals("5")){
                service.SortedMoney();
            }else if(command.equals("6")){
                service.findKeyWordOfNote();
            }else {
                IoManager.print("잘못된 명령을 입력하셨습니다.");
                IoManager.print("다시 입력해주세요");
            }
    }
    private void pause(){
        IoManager.pause();
    }
}
