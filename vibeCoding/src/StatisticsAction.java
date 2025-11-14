import java.util.List;

/**
 * StatisticsAction 클래스
 * 학생들의 통계 정보를 표시합니다.
 * 평균, 최고/최저 점수, 성적 분포 등을 보여줍니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 통계 계산 및 표시만 담당합니다.
 */
public class StatisticsAction extends MenuAction {
    private StudentManager studentManager;
    private MenuDisplay display;

    public StatisticsAction(StudentManager studentManager) {
        super("통계 조회");
        this.studentManager = studentManager;
        this.display = new MenuDisplay();
    }

    @Override
    public boolean execute() {
        display.showSectionTitle("통계 조회");

        if (!studentManager.hasStudents()) {
            display.showMessage("등록된 학생이 없습니다.\n");
            return true;
        }

        printStatistics();
        return true;
    }

    /**
     * 통계 정보를 출력합니다.
     */
    private void printStatistics() {
        List<Student> students = studentManager.getAllStudents();
        
        double totalScore = 0;
        double maxScore = Double.MIN_VALUE;
        double minScore = Double.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;
        int minAge = Integer.MAX_VALUE;
        
        // 기본 통계 계산
        for (Student student : students) {
            totalScore += student.getScore();
            maxScore = Math.max(maxScore, student.getScore());
            minScore = Math.min(minScore, student.getScore());
            maxAge = Math.max(maxAge, student.getAge());
            minAge = Math.min(minAge, student.getAge());
        }

        double averageScore = totalScore / students.size();

        // 학년별 학생 수 계산
        int grade1 = (int) students.stream().filter(s -> s.getGrade() == 1).count();
        int grade2 = (int) students.stream().filter(s -> s.getGrade() == 2).count();
        int grade3 = (int) students.stream().filter(s -> s.getGrade() == 3).count();
        int grade4 = (int) students.stream().filter(s -> s.getGrade() == 4).count();

        // 통계 출력
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📊 기본 통계");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("  총 학생 수:     %d명\n", students.size());
        System.out.printf("  평균 점수:      %.2f점\n", averageScore);
        System.out.printf("  최고 점수:      %.1f점\n", maxScore);
        System.out.printf("  최저 점수:      %.1f점\n", minScore);
        System.out.printf("  점수 편차:      %.1f점\n", maxScore - minScore);
        System.out.println();

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("👥 나이 통계");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("  최대 나이:      %d세\n", maxAge);
        System.out.printf("  최소 나이:      %d세\n", minAge);
        System.out.printf("  평균 나이:      %.1f세\n", 
            students.stream().mapToInt(Student::getAge).average().orElse(0));
        System.out.println();

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📈 성적 분포");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("  1학년 (90~100): %d명 (%.1f%%)\n", 
            grade1, (double)grade1/students.size()*100);
        System.out.printf("  2학년 (80~89):  %d명 (%.1f%%)\n", 
            grade2, (double)grade2/students.size()*100);
        System.out.printf("  3학년 (70~79):  %d명 (%.1f%%)\n", 
            grade3, (double)grade3/students.size()*100);
        System.out.printf("  4학년 (0~69):   %d명 (%.1f%%)\n", 
            grade4, (double)grade4/students.size()*100);
        System.out.println();

        // 점수 구간별 분석
        int score90 = (int) students.stream().filter(s -> s.getScore() >= 90).count();
        int score80 = (int) students.stream().filter(s -> s.getScore() >= 80 && s.getScore() < 90).count();
        int score70 = (int) students.stream().filter(s -> s.getScore() >= 70 && s.getScore() < 80).count();
        int score60 = (int) students.stream().filter(s -> s.getScore() >= 60 && s.getScore() < 70).count();
        int scoreLow = (int) students.stream().filter(s -> s.getScore() < 60).count();

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📊 점수 구간 분석");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        printScoreBar("90~100", score90, students.size());
        printScoreBar("80~89", score80, students.size());
        printScoreBar("70~79", score70, students.size());
        printScoreBar("60~69", score60, students.size());
        printScoreBar("0~59", scoreLow, students.size());
        System.out.println();
    }

    /**
     * 점수 구간을 바 차트로 표시합니다.
     */
    private void printScoreBar(String range, int count, int total) {
        int barLength = (int) ((double)count / total * 30);
        System.out.printf("  %s: ", range);
        for (int i = 0; i < barLength; i++) {
            System.out.print("█");
        }
        System.out.printf(" %d명 (%.1f%%)\n", count, (double)count/total*100);
    }
}
