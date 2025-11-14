/**
 * MenuAction 추상 클래스
 * 컴포지트 패턴의 Leaf 노드로 사용됩니다.
 * 실행 가능한 메뉴 항목(학생 등록, 학생 삭제 등)의 기본 클래스입니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 각 서브클래스는 하나의 기능만 담당합니다.
 * - AddStudentAction: 학생 추가만 담당
 * - DeleteStudentAction: 학생 삭제만 담당
 * - 등등...
 */
public abstract class MenuAction implements MenuItem {
    // 메뉴 액션의 이름 (예: "학생 등록", "학생 삭제" 등)
    protected String name;

    /**
     * MenuAction 생성자
     * 
     * @param name 메뉴 액션의 이름
     */
    public MenuAction(String name) {
        this.name = name;
    }

    /**
     * 메뉴 액션의 이름을 반환합니다.
     * 
     * @return 메뉴 액션의 이름
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * MenuAction은 Leaf 노드이므로 Composite이 아닙니다.
     * 
     * @return 항상 false
     */
    @Override
    public boolean isComposite() {
        return false;
    }

    /**
     * MenuAction은 자식을 가지지 않습니다.
     * 
     * @return 항상 null (Leaf 노드는 자식이 없음)
     */
    @Override
    public java.util.List<MenuItem> getChildren() {
        return null;
    }

    /**
     * 실행 메서드
     * 각 서브클래스에서 구현하여 자신의 기능을 수행합니다.
     * 
     * @return true: 프로그램 계속 실행, false: 프로그램 종료
     */
    @Override
    public abstract boolean execute();
}
