package todo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import todo.dto.Dto;
import todo.util.IoManager;

public class Repository {
    private List<Map<String,Object>> todoDtoList = new ArrayList<>();
    

    public void save(Dto dto){
        Map<String,Object> map = new HashMap<>();
        map.put("todo", dto.getTodo());
        map.put("register", dto.getRegisterDate());
        map.put("complete", dto.getCompleteDate());
        map.put("check", dto.getCompleteCheck());
        map.put("post", dto.getPostscript());
        todoDtoList.add(map);
    }

    public void findAll(){
        for (Map<String, Object> map : todoDtoList) {
            IoManager.print("---------------------");
            IoManager.print("할 일: " + map.get("todo"));
            IoManager.print("등록일: " + map.get("register"));
            IoManager.print("완료일: " + map.get("complete"));
            IoManager.print("완료여부: " + map.get("check"));
            IoManager.print("후기: " + map.get("post"));
        }
    }

    public void checkTodo(String todo){
        for (Map<String, Object> map : todoDtoList) {
            if(map.get("todo").equals(todo)){
                map.put("check", true);
                IoManager.print("---------------------");
                IoManager.print("할 일: " + map.get("todo"));
                IoManager.print("등록일: " + map.get("register"));
                IoManager.print("완료일: " + map.get("complete"));
                IoManager.print("완료여부: " + map.get("check"));
                IoManager.print("후기: " + map.get("post"));
            }

        }
    }

    public void viewOnlyCheckFalse(){
         for (Map<String, Object> map : todoDtoList) {
            if(map.get("check").equals(false)){
                IoManager.print("---------------------");
                IoManager.print("할 일: " + map.get("todo"));
                IoManager.print("등록일: " + map.get("register"));
                IoManager.print("완료일: " + map.get("complete"));
                IoManager.print("완료여부: " + map.get("check"));
                IoManager.print("후기: " + map.get("post"));
            }

        }

    }

    public void viewOnlyCheckTrue(){
        for (Map<String, Object> map : todoDtoList) {
            if(map.get("check").equals(true)){
                IoManager.print("---------------------");
                IoManager.print("할 일: " + map.get("todo"));
                IoManager.print("등록일: " + map.get("register"));
                IoManager.print("완료일: " + map.get("complete"));
                IoManager.print("완료여부: " + map.get("check"));
                IoManager.print("후기: " + map.get("post"));
            }

        }
    }

    public void findByKeyWordOfTitle(String todo){
        for (Map<String, Object> map : todoDtoList) {
            
            String keyword = (String)map.get("todo");
            if(keyword.contains(todo)){
                IoManager.print("---------------------");
                IoManager.print("할 일: " + map.get("todo"));
                IoManager.print("등록일: " + map.get("register"));
                IoManager.print("완료일: " + map.get("complete"));
                IoManager.print("완료여부: " + map.get("check"));
                IoManager.print("후기: " + map.get("post"));
            }

        }
    }
    // 삭제 실패 *********************************************
    public void remove(String todo) {
    int beforeSize = todoDtoList.size();

    // "todo" 키의 값이 일치하는 모든 항목 삭제
    todoDtoList.removeIf(map -> map.get("todo").equals(todo));

    int count = beforeSize - todoDtoList.size();
    IoManager.print("총 " + count + "개의 할일 삭제");
}
}
