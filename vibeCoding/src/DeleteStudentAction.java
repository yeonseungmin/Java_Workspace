/**
 * DeleteStudentAction 클래스
 * 학생 삭제 메뉴를 처리합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 삭제 UI 처리만 담당합니다.
 * - 실제 데이터 삭제는 StudentManager에 위임합니다.
 */
public class DeleteStudentAction extends MenuAction {
    // 학생 데이터 관리자
    private StudentManager studentManager;
    
    // 입력 처리
    private InputHandler inputHandler;
    
    // UI 표시
    private MenuDisplay display;

    /**
     * DeleteStudentAction 생성자
     * 
     * @param studentManager 학생 관리자
     */
    public DeleteStudentAction(StudentManager studentManager) {
        super("학생 삭제");
        this.studentManager = studentManager;
        this.inputHandler = new InputHandler();
        this.display = new MenuDisplay();
    }

    /**
     * 학생 삭제를 실행합니다.
     * 먼저 학생 목록을 표시하고 삭제할 학생을 선택합니다.
     * 
     * @return 항상 true (프로그램 계속 실행)
     */
    @Override
    public boolean execute() {
        display.showSectionTitle("학생 삭제");

        // 등록된 학생이 없으면 종료
        if (!studentManager.hasStudents()) {
            display.showMessage("등록된 학생이 없습니다.\n");
            return true;
        }

        // 현재 등록된 학생 목록 표시
        display.showStudentList(studentManager.getAllStudents());

        // 삭제할 학생의 번호 입력 (1부터 시작)
        int choice = inputHandler.getMenuChoice(studentManager.getStudentCount());
        int index = choice - 1;  // 배열 인덱스로 변환 (0부터 시작)

        // 삭제 확인
        String studentName = studentManager.getStudent(index).getName();
        if (inputHandler.getConfirmation(studentName + " 학생을 삭제하시겠습니까?")) {
            // StudentManager를 통해 학생을 삭제합니다.
            Student removed = studentManager.deleteStudent(index);
            
            if (removed != null) {
                display.showSuccess(removed.getName() + " 학생이 삭제되었습니다.\n");
            } else {
                display.showError("학생 삭제에 실패했습니다.\n");
            }
        } else {
            display.showMessage("삭제가 취소되었습니다.\n");
        }

        return true;
    }
}
