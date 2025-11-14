/**
 * AddStudentAction 클래스
 * 학생 등록 메뉴를 처리합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 등록 UI 처리만 담당합니다.
 * - 실제 데이터 추가는 StudentManager에 위임합니다.
 */
public class AddStudentAction extends MenuAction {
    // 학생 데이터 관리자
    private StudentManager studentManager;
    
    // 입력 처리
    private InputHandler inputHandler;
    
    // UI 표시
    private MenuDisplay display;

    /**
     * AddStudentAction 생성자
     * 
     * @param studentManager 학생 관리자
     */
    public AddStudentAction(StudentManager studentManager) {
        super("학생 등록");
        this.studentManager = studentManager;
        this.inputHandler = new InputHandler();
        this.display = new MenuDisplay();
    }

    /**
     * 학생 등록을 실행합니다.
     * 사용자로부터 학생 정보를 입력받고 등록합니다.
     * 
     * @return 항상 true (프로그램 계속 실행)
     */
    @Override
    public boolean execute() {
        display.showSectionTitle("학생 등록");

        // 학생 이름 입력 (필수)
        String name = inputHandler.getStudentName("이름: ");

        // 학생 나이 입력 (필수, 스킵 불가)
        Integer age = inputHandler.getStudentAge("나이: ", false);

        // 학생 점수 입력 (필수, 스킵 불가)
        Double score = inputHandler.getStudentScore("점수: ", false);

        // 입력받은 정보로 새로운 Student 객체 생성
        Student student = new Student(name, age, score);

        // StudentManager를 통해 학생을 추가합니다.
        if (studentManager.addStudent(student)) {
            display.showSuccess("학생이 등록되었습니다.\n");
        } else {
            display.showError("학생 등록에 실패했습니다.\n");
        }

        return true;
    }
}
