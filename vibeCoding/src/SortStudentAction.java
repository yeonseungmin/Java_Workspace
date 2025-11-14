import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * SortStudentAction 클래스
 * 학생 목록을 다양한 기준으로 정렬하여 표시합니다.
 * 이름, 점수, 나이 순서로 정렬 가능합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 정렬 및 표시 UI 처리만 담당합니다.
 */
public class SortStudentAction extends MenuAction {
    private StudentManager studentManager;
    private InputHandler inputHandler;
    private MenuDisplay display;

    public SortStudentAction(StudentManager studentManager) {
        super("학생 정렬 조회");
        this.studentManager = studentManager;
        this.inputHandler = new InputHandler();
        this.display = new MenuDisplay();
    }

    @Override
    public boolean execute() {
        display.showSectionTitle("학생 정렬 조회");

        if (!studentManager.hasStudents()) {
            display.showMessage("등록된 학생이 없습니다.\n");
            return true;
        }

        System.out.println("1. 이름 순서 (오름차순)");
        System.out.println("2. 점수 순서 (내림차순)");
        System.out.println("3. 점수 순서 (오름차순)");
        System.out.println("4. 나이 순서 (오름차순)");
        System.out.println("5. 학번 순서");
        System.out.println("6. 뒤로가기\n");

        int choice = inputHandler.getMenuChoice(6);

        List<Student> sorted = new ArrayList<>(studentManager.getAllStudents());

        switch (choice) {
            case 1:
                sorted.sort(Comparator.comparing(Student::getName));
                display.showMessage("\n이름 순서 정렬\n");
                break;
            case 2:
                sorted.sort(Comparator.comparingDouble(Student::getScore).reversed());
                display.showMessage("\n점수 순서 (높은 순)\n");
                break;
            case 3:
                sorted.sort(Comparator.comparingDouble(Student::getScore));
                display.showMessage("\n점수 순서 (낮은 순)\n");
                break;
            case 4:
                sorted.sort(Comparator.comparingInt(Student::getAge));
                display.showMessage("\n나이 순서\n");
                break;
            case 5:
                sorted.sort(Comparator.comparing(Student::getStudentId));
                display.showMessage("\n학번 순서\n");
                break;
            case 6:
                return true;
        }

        TablePrinter.printStudentsTable(sorted);
        return true;
    }
}
