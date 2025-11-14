/**
 * ViewStudentAction 클래스
 * 학생 목록 조회 메뉴를 처리합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 목록 표시 UI 처리만 담당합니다.
 * - 실제 데이터 조회는 StudentManager에 위임합니다.
 */
public class ViewStudentAction extends MenuAction {
    // 학생 데이터 관리자
    private StudentManager studentManager;
    
    // UI 표시
    private MenuDisplay display;

    /**
     * ViewStudentAction 생성자
     * 
     * @param studentManager 학생 관리자
     */
    public ViewStudentAction(StudentManager studentManager) {
        super("학생 목록");
        this.studentManager = studentManager;
        this.display = new MenuDisplay();
    }

    /**
     * 학생 목록을 표시합니다.
     * 테이블 형식으로 보기 좋게 표시합니다.
     * 
     * @return 항상 true (프로그램 계속 실행)
     */
    @Override
    public boolean execute() {
        display.showSectionTitle("학생 목록");

        if (!studentManager.hasStudents()) {
            display.showMessage("등록된 학생이 없습니다.\n");
            return true;
        }

        // 테이블 형식으로 학생 목록 표시
        TablePrinter.printStudentsTable(studentManager.getAllStudents());

        return true;
    }
}
