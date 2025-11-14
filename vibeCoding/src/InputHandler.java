import java.util.Scanner;

/**
 * InputHandler 클래스
 * 사용자 입력 처리를 전담하는 클래스입니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 사용자 입력만을 처리합니다.
 * - 입력값 검증과 변환은 이 클래스에서만 수행합니다.
 * - 메뉴 선택 로직, 학생 정보 입력 등 각각의 입력을 담당합니다.
 */
public class InputHandler {
    // Scanner는 정적 변수로 프로그램 전체에서 재사용
    // 여러 InputHandler 인스턴스가 같은 입력 스트림을 사용
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 메뉴 선택을 입력받습니다.
     * 1부터 maxChoice까지의 유효한 정수만 받습니다.
     * 
     * @param maxChoice 선택 가능한 최대 번호
     * @return 사용자가 선택한 번호
     */
    public int getMenuChoice(int maxChoice) {
        while (true) {
            try {
                System.out.print("선택: ");
                int choice = Integer.parseInt(scanner.nextLine());
                
                // 입력값이 유효한 범위인지 확인 (1 ~ maxChoice)
                if (choice >= 1 && choice <= maxChoice) {
                    return choice;
                }
                
                // 범위를 벗어난 경우
                System.out.println("1부터 " + maxChoice + " 사이의 숫자를 입력하세요.\n");
                
            } catch (NumberFormatException e) {
                // 숫자가 아닌 값을 입력한 경우
                System.out.println("숫자를 입력해주세요.\n");
            }
        }
    }

    /**
     * 학생의 이름을 입력받습니다.
     * 빈 문자열은 허용하지 않습니다.
     * 
     * @param prompt 출력할 메시지
     * @return 입력받은 이름
     */
    public String getStudentName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            
            // 빈 문자열이 아닌지 확인
            if (!name.isEmpty()) {
                return name;
            }
            
            System.out.println("이름을 입력해주세요.\n");
        }
    }

    /**
     * 학생의 나이를 입력받습니다.
     * 0부터 150 사이의 정수만 허용합니다.
     * 빈 입력(엔터만 입력)은 스킵하여 null을 반환합니다.
     * 
     * @param prompt 출력할 메시지
     * @param allowSkip true: 엔터로 건너뛰기 가능, false: 필수 입력
     * @return 입력받은 나이 (스킵한 경우 null)
     */
    public Integer getStudentAge(String prompt, boolean allowSkip) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            // allowSkip이 true이고 빈 입력인 경우
            if (allowSkip && input.isEmpty()) {
                return null;  // 건너뜀 신호
            }
            
            try {
                int age = Integer.parseInt(input);
                
                // 나이 범위 확인 (0 ~ 150)
                if (age >= 0 && age <= 150) {
                    return age;
                }
                
                System.out.println("나이는 0부터 150 사이의 값이어야 합니다.\n");
                
            } catch (NumberFormatException e) {
                System.out.println("나이는 숫자로 입력해주세요.\n");
            }
        }
    }

    /**
     * 학생의 점수를 입력받습니다.
     * 0부터 100 사이의 실수만 허용합니다.
     * 빈 입력(엔터만 입력)은 스킵하여 null을 반환합니다.
     * 
     * @param prompt 출력할 메시지
     * @param allowSkip true: 엔터로 건너뛰기 가능, false: 필수 입력
     * @return 입력받은 점수 (스킵한 경우 null)
     */
    public Double getStudentScore(String prompt, boolean allowSkip) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            
            // allowSkip이 true이고 빈 입력인 경우
            if (allowSkip && input.isEmpty()) {
                return null;  // 건너뜀 신호
            }
            
            try {
                double score = Double.parseDouble(input);
                
                // 점수 범위 확인 (0 ~ 100)
                if (score >= 0 && score <= 100) {
                    return score;
                }
                
                System.out.println("점수는 0부터 100 사이의 값이어야 합니다.\n");
                
            } catch (NumberFormatException e) {
                System.out.println("점수는 숫자로 입력해주세요.\n");
            }
        }
    }

    /**
     * 데이터 삭제 또는 중요한 작업 전 사용자 확인을 받습니다.
     * 
     * @param message 확인 메시지
     * @return true: 사용자가 확인(Y), false: 사용자가 취소(N)
     */
    public boolean getConfirmation(String message) {
        while (true) {
            System.out.print(message + " (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Y 또는 N을 입력해주세요.\n");
            }
        }
    }

    /**
     * Scanner를 종료합니다.
     * 프로그램 종료 시 호출되어야 합니다.
     */
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
