import java.util.ArrayList;

/**
 * App 클래스 (리팩토링)
 * 학생 관리 프로그램의 메인 클래스입니다.
 * 
 * 설계 원칙:
 * - 컴포지트 패턴: 메뉴를 트리 구조로 구성
 * - SRP(Single Responsibility Principle): 각 클래스가 단일 책임 수행
 * - 인터페이스 기반 설계: MenuItem 인터페이스를 통한 다형성 활용
 * 
 * 아키텍처:
 * Menu (Composite)
 *   ├── AddStudentAction (Leaf)
 *   ├── DeleteStudentAction (Leaf)
 *   ├── UpdateStudentAction (Leaf)
 *   ├── ViewStudentAction (Leaf)
 *   └── ExitAction (Leaf)
 */
public class App {
    // 학생 데이터를 관리하는 StudentManager
    private static ArrayList<Student> students;
    private static StudentManager studentManager;

    /**
     * main 메서드
     * 프로그램의 시작점입니다.
     * 
     * 실행 순서:
     * 1. 파일에서 학생 데이터 로드
     * 2. 메뉴 구조 생성 (컴포지트 패턴)
     * 3. 메인 메뉴 실행
     * 4. 프로그램 종료 시 데이터 저장
     */
    public static void main(String[] args) {
        try {
            // ========== 1단계: 데이터 로드 ==========
            initializeData();

            // ========== 2단계: 메뉴 구조 생성 (컴포지트 패턴) ==========
            MenuItem mainMenu = createMainMenu();

            // ========== 3단계: 메인 메뉴 실행 ==========
            showWelcomeMessage();
            mainMenu.execute();

            // ========== 4단계: 프로그램 종료 ==========
            saveAndExit();

        } catch (Exception e) {
            System.out.println("예상치 못한 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 데이터 초기화
     * 파일에서 학생 정보를 로드합니다.
     */
    private static void initializeData() {
        // FileManager를 통해 저장된 파일에서 학생 데이터 로드
        students = FileManager.loadStudents();
        
        // StudentManager 생성 (학생 데이터 비즈니스 로직 담당)
        studentManager = new StudentManager(students);
        
        System.out.println();
    }

    /**
     * 메뉴 구조 생성 (컴포지트 패턴 구현)
     * 
     * 메뉴 트리 구조:
     * 메인 메뉴
     *   ├── 학생 관리
     *   │    ├── 학생 등록
     *   │    ├── 학생 삭제
     *   │    ├── 학생 수정
     *   │    ├── 학생 목록
     *   │    └── 학생 검색
     *   ├── 조회 및 분석
     *   │    ├── 정렬 조회
     *   │    └── 통계 조회
     *   └── 종료 (파일 저장)
     * 
     * @return 메인 메뉴 (Menu)
     */
    private static MenuItem createMainMenu() {
        // 루트 메뉴 (Composite)
        Menu mainMenu = new Menu("메인 메뉴");

        // ========== 학생 관리 메뉴 ==========
        Menu studentManagementMenu = new Menu("학생 관리");
        studentManagementMenu.addChild(new AddStudentAction(studentManager));
        studentManagementMenu.addChild(new DeleteStudentAction(studentManager));
        studentManagementMenu.addChild(new UpdateStudentAction(studentManager));
        studentManagementMenu.addChild(new ViewStudentAction(studentManager));
        studentManagementMenu.addChild(new SearchStudentAction(studentManager));

        mainMenu.addChild(studentManagementMenu);

        // ========== 조회 및 분석 메뉴 ==========
        Menu analysisMenu = new Menu("조회 및 분석");
        analysisMenu.addChild(new SortStudentAction(studentManager));
        analysisMenu.addChild(new StatisticsAction(studentManager));

        mainMenu.addChild(analysisMenu);
        
        // ========== 종료 ==========
        mainMenu.addChild(new ExitAction());

        return mainMenu;
    }

    /**
     * 환영 메시지 표시
     */
    private static void showWelcomeMessage() {
        MenuDisplay display = new MenuDisplay();
        display.showWelcome();
    }

    /**
     * 프로그램 종료 및 데이터 저장
     */
    private static void saveAndExit() {
        // 현재 학생 정보를 파일에 저장
        FileManager.saveStudents(students);
        
        // Scanner 자원 해제
        InputHandler.closeScanner();
    }
}

