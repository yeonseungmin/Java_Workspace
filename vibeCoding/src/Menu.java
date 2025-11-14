import java.util.ArrayList;
import java.util.List;

/**
 * Menu 클래스 (Composite)
 * 컴포지트 패턴의 Composite 역할을 합니다.
 * 다른 메뉴 항목들을 자식으로 가질 수 있습니다.
 * 주로 메뉴 그룹이나 서브메뉴를 나타냅니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 메뉴 계층 구조 관리만을 담당합니다.
 * - 실제 메뉴 실행 로직은 각 Leaf 노드가 담당합니다.
 */
public class Menu implements MenuItem {
    // 메뉴의 이름 (예: "메인 메뉴", "학생 관리", "설정" 등)
    private String name;
    
    // 이 메뉴 아래의 자식 메뉴 항목들을 저장하는 리스트
    // Leaf 노드(실행 가능한 메뉴 항목)와 Composite 노드(서브메뉴) 모두 포함
    private List<MenuItem> children;

    /**
     * Menu 생성자
     * 새로운 메뉴 그룹을 생성합니다.
     * 
     * @param name 메뉴의 이름
     */
    public Menu(String name) {
        this.name = name;
        // ArrayList를 사용하여 동적으로 자식 메뉴를 추가/제거 가능
        this.children = new ArrayList<>();
    }

    /**
     * 이 메뉴에 자식 메뉴 항목을 추가합니다.
     * 컴포지트 패턴의 add 메서드입니다.
     * 
     * 예시:
     * Menu mainMenu = new Menu("메인 메뉴");
     * Menu studentMenu = new Menu("학생 관리");
     * mainMenu.addChild(studentMenu);
     * 
     * @param child 추가할 자식 메뉴 항목 (MenuItem 인터페이스 구현)
     */
    public void addChild(MenuItem child) {
        // null 체크: 자식이 null이 아닌지 확인
        if (child != null) {
            children.add(child);
        }
    }

    /**
     * 메뉴의 이름을 반환합니다.
     * 
     * @return 메뉴의 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 메뉴를 실행합니다.
     * Composite 노드이므로 자식 메뉴들을 표시하고 사용자 입력을 받습니다.
     * 
     * @return true: 프로그램 계속 실행, false: 프로그램 종료
     */
    @Override
    public boolean execute() {
        // MenuDisplay: 메뉴 화면 표시 담당 (SRP)
        MenuDisplay display = new MenuDisplay();
        
        // 무한 루프: 사용자가 부모 메뉴로 돌아가기를 선택할 때까지
        while (true) {
            // 현재 메뉴와 자식 메뉴들을 화면에 표시
            display.showMenu(this);
            
            // InputHandler: 사용자 입력 처리 담당 (SRP)
            InputHandler input = new InputHandler();
            int choice = input.getMenuChoice(children.size() + 1);  // +1은 뒤로가기
            
            // 사용자가 선택한 항목에 따라 처리
            if (choice == children.size() + 1) {
                // 마지막 선택지는 "뒤로가기"
                // true를 반환하여 호출한 메서드가 계속 실행되도록 함
                return true;
            } else if (choice >= 1 && choice <= children.size()) {
                // 선택한 항목의 인덱스 (1부터 시작하므로 -1 처리)
                MenuItem selectedItem = children.get(choice - 1);
                
                // 선택한 항목을 실행하고 반환값 확인
                boolean continueProgram = selectedItem.execute();
                
                // false 반환: 프로그램 종료 신호
                if (!continueProgram) {
                    return false;
                }
                // true 반환: 계속 실행, 다시 현재 메뉴로 돌아옴
            }
        }
    }

    /**
     * 이 Menu는 Composite 노드입니다.
     * 
     * @return 항상 true
     */
    @Override
    public boolean isComposite() {
        return true;
    }

    /**
     * 자식 메뉴 항목들을 반환합니다.
     * 
     * @return 자식 MenuItem 리스트
     */
    @Override
    public List<MenuItem> getChildren() {
        return children;
    }
}
