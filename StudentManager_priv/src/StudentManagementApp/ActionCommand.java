package StudentManagementApp;

public class ActionCommand implements MenuItem {
    private String name;
    private Runnable action; // 실행할 실제 로직 (Lambda 사용 가능)

    public ActionCommand(String name, Runnable action) {
        this.name = name;
        this.action = action;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute() {
        System.out.println(">> 기능 실행: " + name);
        action.run(); // 실제 로직 실행
    }
}
