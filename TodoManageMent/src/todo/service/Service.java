package todo.service;

import java.time.LocalDateTime;
import todo.dto.Dto;
import todo.repository.Repository;
import todo.util.IoManager;

public class Service {
    private Repository repository = new Repository();
    

    public void addTodo(){
        IoManager.print("==============제목 입력=============");
        String todo = IoManager.input("할일 입력 > ");
        int mm = Integer.parseInt(IoManager.input("월 등록 >"));
        int dd = Integer.parseInt(IoManager.input("일 등록 >"));
        LocalDateTime register = LocalDateTime.of(2025, mm, dd, 0, 0, 0);
        int date = Integer.parseInt(IoManager.input("완료까지 걸리는 일 수 > "));
        LocalDateTime complete = register.plusDays(date);
        boolean check = booleanCheck();
        String post = IoManager.input("메모 입력 > ");
        Dto dto = new Dto(todo, register, complete, check, post);
        repository.save(dto);
        
        IoManager.print("===================================");
    }

    public void viewRegisterDate(){
        IoManager.print("============전체 목록 보기==============");
        repository.findAll();
        IoManager.print("=====================================");
    }
    public void checkTodo(){
        IoManager.print("============완료 처리 하기=============");
        String todo = IoManager.input("완료 할 일을 입력 > ");
        repository.checkTodo(todo);
        IoManager.print("=====================================");
    }

    public void viewOnlyCheckFalse(){
        IoManager.print("=============미완료만 보기=============");
        repository.viewOnlyCheckFalse();
        IoManager.print("=====================================");
    }

    public void viewOnlyCheckTrue(){
        IoManager.print("============완료만 보기===============");
        repository.viewOnlyCheckTrue();
        IoManager.print("=====================================");
    }

    public void findByKeyWordOfTitle(){
        IoManager.print("=====================================");
        String keyword = IoManager.input("검색할 키워드 > ");
        repository.findByKeyWordOfTitle(keyword);

        IoManager.print("=====================================");
    }

    public void remove(){
        IoManager.print("=====================================");
        String keyword = IoManager.input("삭제할 할 일 > ");
        
        repository.remove(keyword);
        IoManager.print("=====================================");
    }

    public boolean booleanCheck(){
        boolean whileCheck = true;
        boolean check = false;
        while(whileCheck){
            String checkComplete = IoManager.input("Y/N 을 입력 > ");
            if(checkComplete.equals("Y")|| checkComplete.equals("y")){
                check = true;
                whileCheck = false;
            }else if(checkComplete.equals("N")||checkComplete.equals("n")){
                check = false;
                whileCheck = false;
            }else{
                IoManager.print("잘못된 입력");
                continue;
            }
        }return check;
    }
}
