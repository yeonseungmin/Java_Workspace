package com.pr.std.controller;

import com.pr.std.service.Service;
import com.pr.std.util.IoManager;

public class Controller {
    private Service service = new Service();
    public void run(){
        welcom();
        while(true){
            showMenu();
            String command = selectCommand();
            if(isExitCommand(command)){
                break;
            }
            processCommand(command);
            pause();
        }
        bye();
    }
    public void welcom(){
        IoManager.print("*******************************");
        IoManager.print("      학생 관리 프로그램 .v2      ");
        IoManager.print("           2025.10.17          ");
        IoManager.print("*******************************");
    }
    public void showMenu(){
            IoManager.print("[ 메뉴 ]");
            IoManager.print(" 1. 학생 정보 등록 ");
            IoManager.print(" 2. 학생 정보 목록 ");
            IoManager.print(" 3. 학생 정보 검색 ");
            IoManager.print(" 4. 학생 정보 삭제 ");
            IoManager.print(" 5. 학생 정보 수정 ");
            IoManager.print(" 6. 학생 정보 통계 ");
            IoManager.print(" 0. 프로그램 종료  ");
    }

    public String selectCommand(){
        String command = IoManager.input("선택 > ");
        return command;
    }
    public boolean isExitCommand(String command){
        return command.equals("0");
    }
    public void processCommand(String command){
            if(command.equals("1")){
                service.addStudent();
            }else if(command.equals("2")){
                service.listStudent();
            }else if(command.equals("3")){
                service.searchStudent();
            }else if(command.equals("4")){
                service.removeStudent();
            }else if(command.equals("5")){
                
            }else if(command.equals("6")){
                service.statistize();
            }else {
                IoManager.print("잘못된 명령을 입력하셨습니다.");
                IoManager.print("다시 입력해주세요");
            }
    }
    private void pause(){
        IoManager.pause();
    }
    private void bye(){
        IoManager.print("프로그램이 종료됩니다.");
    }
}
