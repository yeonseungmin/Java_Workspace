import java.util.List;

/**
 * MenuDisplay 클래스
 * 메뉴를 화면에 표시하는 것만을 담당하는 클래스입니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 메뉴 표시(UI 출력)만을 담당합니다.
 * - 메뉴 선택 로직이나 데이터 처리와는 무관합니다.
 * - 다양한 메뉴 형식을 표시할 수 있습니다.
 */
public class MenuDisplay {
    // 메뉴 구분선의 길이 (시각적 구분)
    private static final int SEPARATOR_LENGTH = 30;

    /**
     * 메뉴와 그 자식 메뉴 항목들을 화면에 표시합니다.
     * 계층 구조를 깔끔하게 보여줍니다.
     * 
     * @param menu 표시할 메뉴
     */
    public void showMenu(MenuItem menu) {
        // 구분선 출력 (시각적 효과)
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // 메뉴 제목 출력
        System.out.println("  📋 " + menu.getName());
        
        // 구분선 출력
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // 자식 메뉴 항목들 출력
        List<MenuItem> children = menu.getChildren();
        for (int i = 0; i < children.size(); i++) {
            String icon = getMenuIcon(i);
            System.out.println("  " + (i + 1) + ". " + icon + " " + children.get(i).getName());
        }
        
        // 뒤로가기 옵션 (마지막 번호)
        System.out.println("  " + (children.size() + 1) + ". 🔙 뒤로가기");
        System.out.println();
    }

    /**
     * 메뉴 인덱스에 따른 아이콘을 반환합니다.
     * 
     * @param index 메뉴 인덱스
     * @return 아이콘 문자열
     */
    private String getMenuIcon(int index) {
        String[] icons = {"➕", "➖", "✏️", "📄", "🔍", "📊", "⚙️"};
        if (index < icons.length) {
            return icons[index];
        }
        return "➤";
    }

    /**
     * 구분선을 출력합니다.
     * 메뉴를 시각적으로 구분하기 위해 사용됩니다.
     */
    private void printSeparator() {
        // 등호(=) 문자를 SEPARATOR_LENGTH만큼 반복 출력
        for (int i = 0; i < SEPARATOR_LENGTH; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    /**
     * 단순 메시지를 출력합니다.
     * 작업 결과나 안내 메시지를 표시할 때 사용합니다.
     * 
     * @param message 출력할 메시지
     */
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * 에러 메시지를 출력합니다.
     * 에러 메시지는 시각적으로 다르게 표시됩니다.
     * 
     * @param message 에러 메시지
     */
    public void showError(String message) {
        System.out.println("✗ " + message);
    }

    /**
     * 성공 메시지를 출력합니다.
     * 성공 메시지는 시각적으로 다르게 표시됩니다.
     * 
     * @param message 성공 메시지
     */
    public void showSuccess(String message) {
        System.out.println("✓ " + message);
    }

    /**
     * 학생 목록을 표시합니다.
     * 
     * @param students 표시할 학생 리스트
     */
    public void showStudentList(java.util.List<Student> students) {
        if (students.isEmpty()) {
            showMessage("등록된 학생이 없습니다.\n");
            return;
        }
        
        printSeparator();
        System.out.println("=== 학생 목록 ===");
        printSeparator();
        
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
        System.out.println();
    }

    /**
     * 학생 정보를 상세하게 표시합니다.
     * 
     * @param student 표시할 학생
     */
    public void showStudentDetail(Student student) {
        System.out.println("\n현재 정보: " + student);
    }

    /**
     * 환영 메시지를 출력합니다.
     */
    public void showWelcome() {
        printLargeSeparator();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃     🎓 학생 관리 시스템 v1.0    ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();
    }

    /**
     * 섹션 제목을 표시합니다.
     * 
     * @param title 섹션 제목
     */
    public void showSectionTitle(String title) {
        printSeparator();
        System.out.println("=== " + title + " ===");
        printSeparator();
    }

    /**
     * 큰 구분선을 출력합니다.
     */
    private void printLargeSeparator() {
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}
