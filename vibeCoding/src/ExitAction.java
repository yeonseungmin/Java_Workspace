/**
 * ExitAction 클래스
 * 프로그램 종료 메뉴를 처리합니다.
 * 종료 시 현재 데이터를 파일에 저장합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 프로그램 종료만 담당합니다.
 * - 파일 저장은 FileManager에 위임합니다.
 */
public class ExitAction extends MenuAction {
    // UI 표시
    private MenuDisplay display;

    /**
     * ExitAction 생성자
     */
    public ExitAction() {
        super("종료 (파일 저장)");
        this.display = new MenuDisplay();
    }

    /**
     * 프로그램을 종료합니다.
     * 현재 데이터를 파일에 저장하고 false를 반환하여 프로그램 종료를 신호합니다.
     * 
     * @return false (프로그램 종료 신호)
     */
    @Override
    public boolean execute() {
        // 프로그램 종료 메시지
        display.showSuccess("프로그램을 종료합니다.");
        
        // false 반환: 메인 메뉴 루프 탈출
        return false;
    }
}
