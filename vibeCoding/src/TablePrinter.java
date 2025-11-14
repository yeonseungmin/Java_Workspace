import java.util.List;

/**
 * TablePrinter 클래스
 * 테이블 형식으로 데이터를 출력하는 클래스입니다.
 * 아스키 문자를 사용하여 보기 좋은 테이블을 만듭니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 테이블 형식 출력만을 담당합니다.
 */
public class TablePrinter {
    // 테이블 테두리 문자
    private static final String HORIZONTAL = "─";
    private static final String VERTICAL = "│";
    private static final String CORNER_TL = "┌";
    private static final String CORNER_TR = "┐";
    private static final String CORNER_BL = "└";
    private static final String CORNER_BR = "┘";
    private static final String CROSS_T = "┬";
    private static final String CROSS_B = "┴";
    private static final String CROSS_L = "├";
    private static final String CROSS_R = "┤";
    private static final String CROSS = "┼";

    private int[] columnWidths;
    private String[] headers;

    /**
     * TablePrinter 생성자
     * 
     * @param headers 테이블 헤더
     * @param columnWidths 각 컬럼의 너비
     */
    public TablePrinter(String[] headers, int[] columnWidths) {
        this.headers = headers;
        this.columnWidths = columnWidths;
    }

    /**
     * 테이블 헤더를 출력합니다.
     */
    public void printHeader() {
        printTopBorder();
        printRow(headers);
        printMiddleBorder();
    }

    /**
     * 테이블 데이터 행을 출력합니다.
     * 
     * @param row 출력할 행 데이터
     */
    public void printRow(String[] row) {
        for (int i = 0; i < row.length; i++) {
            System.out.print(VERTICAL);
            System.out.print(padCenter(row[i], columnWidths[i]));
        }
        System.out.println(VERTICAL);
    }

    /**
     * 테이블 하단 테두리를 출력합니다.
     */
    public void printFooter() {
        printBottomBorder();
    }

    /**
     * 상단 테두리를 출력합니다.
     */
    private void printTopBorder() {
        System.out.print(CORNER_TL);
        for (int i = 0; i < columnWidths.length; i++) {
            for (int j = 0; j < columnWidths[i]; j++) {
                System.out.print(HORIZONTAL);
            }
            if (i < columnWidths.length - 1) {
                System.out.print(CROSS_T);
            }
        }
        System.out.println(CORNER_TR);
    }

    /**
     * 중간 테두리를 출력합니다 (헤더 아래).
     */
    private void printMiddleBorder() {
        System.out.print(CROSS_L);
        for (int i = 0; i < columnWidths.length; i++) {
            for (int j = 0; j < columnWidths[i]; j++) {
                System.out.print(HORIZONTAL);
            }
            if (i < columnWidths.length - 1) {
                System.out.print(CROSS);
            }
        }
        System.out.println(CROSS_R);
    }

    /**
     * 하단 테두리를 출력합니다.
     */
    private void printBottomBorder() {
        System.out.print(CORNER_BL);
        for (int i = 0; i < columnWidths.length; i++) {
            for (int j = 0; j < columnWidths[i]; j++) {
                System.out.print(HORIZONTAL);
            }
            if (i < columnWidths.length - 1) {
                System.out.print(CROSS_B);
            }
        }
        System.out.println(CORNER_BR);
    }

    /**
     * 문자열을 지정된 너비로 중앙 정렬합니다.
     * 
     * @param text 정렬할 텍스트
     * @param width 너비
     * @return 정렬된 문자열
     */
    private String padCenter(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int totalPadding = width - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }

    /**
     * 학생 정보를 테이블 형식으로 출력합니다.
     * 
     * @param students 출력할 학생 리스트
     */
    public static void printStudentsTable(List<Student> students) {
        String[] headers = {"번호", "학번", "이름", "나이", "점수", "학년", "등록일"};
        int[] columnWidths = {6, 10, 12, 6, 8, 6, 12};

        TablePrinter printer = new TablePrinter(headers, columnWidths);
        
        printer.printHeader();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            String[] row = {
                String.valueOf(i + 1),
                s.getStudentId(),
                s.getName(),
                String.valueOf(s.getAge()),
                String.format("%.1f", s.getScore()),
                String.valueOf(s.getGrade()),
                s.getEnrollmentDate()
            };
            printer.printRow(row);
        }
        printer.printFooter();
        System.out.println();
    }
}
