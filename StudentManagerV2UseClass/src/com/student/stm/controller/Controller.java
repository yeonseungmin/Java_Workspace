package com.student.stm.controller;

import com.student.stm.util.IoManager;

// 현재 : 전체 흐름을 담당한다.
    // 스프링에서는 사용자 입출력 담당
public class Controller {

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
        IoManager.print("      학생 관리 프로그램 .v2      ");
        IoManager.print("           2025.10.17          ");
        IoManager.print("*******************************");
    }
    private void bye(){
        IoManager.print("프로그램이 종료됩니다.");
    }

    private void showMenu(){
            IoManager.print("[ 메뉴 ]");
            IoManager.print(" 1. 학생 정보 등록 ");
            IoManager.print(" 2. 학생 정보 목록 ");
            IoManager.print(" 3. 학생 정보 검색 ");
            IoManager.print(" 4. 학생 정보 삭제 ");
            IoManager.print(" 5. 학생 정보 수정 ");
            IoManager.print(" 6. 학생 정보 통계 ");
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

            }else if(command.equals("2")){

            }else if(command.equals("3")){

            }else if(command.equals("4")){

            }else if(command.equals("5")){
                
            }else if(command.equals("6")){

            }else {
                IoManager.print("잘못된 명령을 입력하셨습니다.");
                IoManager.print("다시 입력해주세요");
            }
    }
    private void pause(){
        IoManager.pause();
    }
}
