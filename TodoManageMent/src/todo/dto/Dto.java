package todo.dto;

import java.time.LocalDateTime;

public class Dto {

    private String todo;
    private LocalDateTime registerDate;
    private LocalDateTime completeDate;
    private boolean completeCheck;
    private String postscript;

    
    public Dto(String todo,LocalDateTime registerDate,LocalDateTime completeDate,boolean completeCheck,String postscript){
            this.todo = todo;
            this.registerDate = registerDate;
            this.completeDate = completeDate;
            this.completeCheck =completeCheck;
            this.postscript =postscript;
            }
    public Dto(String todo,LocalDateTime registerDate,LocalDateTime completeDate){
            this.todo =todo;
            this.registerDate = registerDate;
            this.completeDate = completeDate;
            }
    public Dto(String todo){
            this.todo = todo;
    }

            public void setTodo(String todo){
                this.todo =todo;
            }
            public String getTodo(){
                return todo;
            }
            public void setRegisterDate(LocalDateTime registerDate){
                this.registerDate = registerDate;
            }
            public LocalDateTime getRegisterDate(){
                return registerDate;
            }


            public void setCompleteDate(LocalDateTime completeDate){
                this.completeDate =completeDate;
            }
            public LocalDateTime getCompleteDate(){
                return completeDate;
            }
            public void setCompleteCheck(boolean completeCheck){
                this.completeCheck =completeCheck;
            }
            public boolean getCompleteCheck(){
                return completeCheck;
            }
            public void setPostscript(String postscript){
                this.postscript =postscript;
            }
            public String getPostscript(){
                return postscript;
            }
}


