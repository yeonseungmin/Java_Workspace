/**
 * MenuItem 인터페이스
 * 컴포지트 패턴을 구현하기 위한 인터페이스입니다.
 * 메뉴 항목(Leaf)과 메뉴 그룹(Composite) 모두 이 인터페이스를 구현합니다.
 */
public interface MenuItem {
    /**
     * 메뉴 항목의 이름을 반환합니다.
     * 
     * @return 메뉴 항목의 이름
     */
    String getName();

    /**
     * 메뉴를 실행합니다.
     * Leaf 노드: 실제 기능을 수행
     * Composite 노드: 서브메뉴를 표시
     * 
     * @return 계속 실행할지 여부 (true: 계속, false: 종료)
     */
    boolean execute();

    /**
     * 메뉴가 Composite 노드인지 확인합니다.
     * 
     * @return true: Composite 노드, false: Leaf 노드
     */
    boolean isComposite();

    /**
     * Composite 노드의 자식 메뉴들을 반환합니다.
     * Leaf 노드는 null을 반환합니다.
     * 
     * @return 자식 MenuItem 리스트 (Leaf 노드인 경우 null)
     */
    java.util.List<MenuItem> getChildren();
}
