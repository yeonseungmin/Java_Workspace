import java.util.ArrayList;
import java.util.List;

/**
 * SearchStudentAction 클래스
 * 학생을 검색하는 메뉴를 처리합니다.
 * 이름, 학번으로 검색 가능합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 검색 UI 처리만 담당합니다.
 */
public class SearchStudentAction extends MenuAction {
    private StudentManager studentManager;
    private InputHandler inputHandler;
    private MenuDisplay display;

    public SearchStudentAction(StudentManager studentManager) {
        super("학생 검색");
        this.studentManager = studentManager;
        this.inputHandler = new InputHandler();
        this.display = new MenuDisplay();
    }

    @Override
    public boolean execute() {
        display.showSectionTitle("학생 검색");

        if (!studentManager.hasStudents()) {
            display.showMessage("등록된 학생이 없습니다.\n");
            return true;
        }

        System.out.println("1. 이름으로 검색");
        System.out.println("2. 학번으로 검색");
        System.out.println("3. 점수 범위로 검색");
        System.out.println("4. 뒤로가기\n");

        int choice = inputHandler.getMenuChoice(4);

        switch (choice) {
            case 1:
                searchByName();
                break;
            case 2:
                searchByStudentId();
                break;
            case 3:
                searchByScoreRange();
                break;
            case 4:
                return true;
        }

        return true;
    }

    /**
     * 이름으로 학생을 검색합니다.
     */
    private void searchByName() {
        System.out.print("\n검색할 이름: ");
        String searchName = inputHandler.getStudentName("");
        
        List<Student> results = new ArrayList<>();
        for (Student student : studentManager.getAllStudents()) {
            if (student.getName().contains(searchName)) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            display.showMessage("검색 결과가 없습니다.\n");
        } else {
            display.showMessage("검색 결과: " + results.size() + "명\n");
            TablePrinter.printStudentsTable(results);
        }
    }

    /**
     * 학번으로 학생을 검색합니다.
     */
    private void searchByStudentId() {
        System.out.print("\n검색할 학번: ");
        String searchId = inputHandler.getStudentName("");
        
        List<Student> results = new ArrayList<>();
        for (Student student : studentManager.getAllStudents()) {
            if (student.getStudentId().contains(searchId)) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            display.showMessage("검색 결과가 없습니다.\n");
        } else {
            display.showMessage("검색 결과: " + results.size() + "명\n");
            TablePrinter.printStudentsTable(results);
        }
    }

    /**
     * 점수 범위로 학생을 검색합니다.
     */
    private void searchByScoreRange() {
        Double minScore = inputHandler.getStudentScore("\n최소 점수: ", false);
        Double maxScore = inputHandler.getStudentScore("최대 점수: ", false);
        
        if (minScore == null || maxScore == null) {
            display.showMessage("유효한 점수를 입력해주세요.\n");
            return;
        }

        List<Student> results = new ArrayList<>();
        for (Student student : studentManager.getAllStudents()) {
            if (student.getScore() >= minScore && student.getScore() <= maxScore) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            display.showMessage("검색 결과가 없습니다.\n");
        } else {
            display.showMessage("검색 결과: " + results.size() + "명\n");
            TablePrinter.printStudentsTable(results);
        }
    }
}
