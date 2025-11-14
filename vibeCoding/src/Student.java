import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Student 클래스 (확장)
 * 학생의 정보를 저장하고 관리하는 클래스입니다.
 * 학생의 이름, 나이, 점수, 학번, 학년, 등록일 등을 속성으로 가지고 있습니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 데이터만을 담당합니다.
 */
public class Student {
    // 학생의 고유 학번 (STUD + 타임스탬프)
    private String studentId;
    
    // 학생의 이름을 저장하는 변수 (private: 외부에서 직접 접근 불가)
    private String name;
    
    // 학생의 나이를 저장하는 변수 (정수 타입)
    private int age;
    
    // 학생의 점수를 저장하는 변수 (소수점까지 표현 가능)
    private double score;
    
    // 학생의 학년 (1~4학년)
    private int grade;
    
    // 학생의 등록일
    private String enrollmentDate;
    
    // 날짜 포맷터
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Student 생성자
     * 새로운 Student 객체를 생성할 때 필수 정보를 초기화합니다.
     * 학번은 자동으로 생성되고 등록일은 현재 날짜로 설정됩니다.
     * 
     * @param name 학생의 이름
     * @param age 학생의 나이
     * @param score 학생의 점수
     */
    public Student(String name, int age, double score) {
        this.studentId = generateStudentId();
        this.name = name;
        this.age = age;
        this.score = score;
        this.grade = calculateGrade(score);
        this.enrollmentDate = LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 점수에 따른 학년을 계산합니다.
     * 90점 이상: 1학년, 80점 이상: 2학년, 70점 이상: 3학년, 미만: 4학년
     * 
     * @param score 학생의 점수
     * @return 학년
     */
    private int calculateGrade(double score) {
        if (score >= 90) return 1;
        if (score >= 80) return 2;
        if (score >= 70) return 3;
        return 4;
    }

    /**
     * 고유한 학번을 생성합니다.
     * 형식: STUD + 현재 시간 (밀리초)
     * 
     * @return 생성된 학번
     */
    private String generateStudentId() {
        return "STUD" + System.currentTimeMillis();
    }

    /**
     * Getter 메서드들: 클래스 변수의 값을 읽기만 하는 메서드들
     * private 변수에 접근하기 위해 getter 메서드를 사용합니다.
     */
    
    /**
     * 학생의 학번을 반환합니다.
     * @return 학생의 학번
     */
    public String getStudentId() {
        return studentId;
    }
    
    /**
     * 학생의 이름을 반환합니다.
     * @return 학생의 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 학생의 나이를 반환합니다.
     * @return 학생의 나이
     */
    public int getAge() {
        return age;
    }

    /**
     * 학생의 점수를 반환합니다.
     * @return 학생의 점수
     */
    public double getScore() {
        return score;
    }
    
    /**
     * 학생의 학년을 반환합니다.
     * @return 학생의 학년
     */
    public int getGrade() {
        return grade;
    }
    
    /**
     * 학생의 등록일을 반환합니다.
     * @return 학생의 등록일
     */
    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    /**
     * Setter 메서드들: 클래스 변수의 값을 변경하는 메서드들
     * private 변수를 수정하기 위해 setter 메서드를 사용합니다.
     */
    
    /**
     * 학생의 이름을 설정합니다.
     * @param name 새로운 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 학생의 나이를 설정합니다.
     * @param age 새로운 나이
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 학생의 점수를 설정합니다.
     * @param score 새로운 점수
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * toString 메서드
     * 객체를 문자열로 표현하는 메서드입니다.
     * 학생 정보를 보기 좋은 형태로 반환합니다.
     * System.out.println(student)와 같이 사용할 때 자동으로 호출됩니다.
     * 
     * @return 학생 정보를 포함한 문자열
     */
    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age + ", 점수: " + score;
    }
}
