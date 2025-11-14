/**
 * UpdateStudentAction 클래스
 * 학생 정보 수정 메뉴를 처리합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 수정 UI 처리만 담당합니다.
 * - 실제 데이터 수정은 StudentManager에 위임합니다.
 */
public class UpdateStudentAction extends MenuAction {
    // 학생 데이터 관리자
    private StudentManager studentManager;
    
    // 입력 처리
    private InputHandler inputHandler;
    
    // UI 표시
    private MenuDisplay display;

    /**
     * UpdateStudentAction 생성자
     * 
     * @param studentManager 학생 관리자
     */
    public UpdateStudentAction(StudentManager studentManager) {
        super("학생 수정");
        this.studentManager = studentManager;
        this.inputHandler = new InputHandler();
        this.display = new MenuDisplay();
    }

    /**
     * 학생 정보 수정을 실행합니다.
     * 수정할 학생을 선택하고 변경할 정보를 입력받습니다.
     * 엔터를 입력하면 해당 항목은 수정하지 않습니다.
     * 
     * @return 항상 true (프로그램 계속 실행)
     */
    @Override
    public boolean execute() {
        display.showSectionTitle("학생 수정");

        // 등록된 학생이 없으면 종료
        if (!studentManager.hasStudents()) {
            display.showMessage("등록된 학생이 없습니다.\n");
            return true;
        }

        // 현재 등록된 학생 목록 표시
        display.showStudentList(studentManager.getAllStudents());

        // 수정할 학생의 번호 입력 (1부터 시작)
        int choice = inputHandler.getMenuChoice(studentManager.getStudentCount());
        int index = choice - 1;  // 배열 인덱스로 변환 (0부터 시작)

        Student student = studentManager.getStudent(index);
        
        // 현재 학생 정보 표시
        display.showStudentDetail(student);
        System.out.println("\n수정할 정보를 입력하세요 (엔터로 건너뛰기):\n");

        // 각 필드를 수정 (null 값은 건너뛰기)
        String newName = inputHandler.getStudentName("이름: ");
        newName = newName.isEmpty() ? null : newName;

        Integer newAge = inputHandler.getStudentAge("나이: ", true);

        Double newScore = inputHandler.getStudentScore("점수: ", true);

        // StudentManager를 통해 학생 정보를 수정합니다.
        if (studentManager.updateStudent(index, newName, newAge, newScore)) {
            display.showSuccess("학생 정보가 수정되었습니다.\n");
        } else {
            display.showError("학생 정보 수정에 실패했습니다.\n");
        }

        return true;
    }
}
