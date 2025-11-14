import java.util.ArrayList;

/**
 * StudentManager 클래스
 * 학생 정보에 대한 모든 비즈니스 로직을 담당합니다.
 * 
 * 단일 책임 원칙(SRP):
 * - 학생 데이터 관리 (추가, 삭제, 수정, 조회)만을 담당합니다.
 * - UI 표시, 파일 관리 등과는 분리되어 있습니다.
 */
public class StudentManager {
    // 모든 학생 정보를 저장하는 리스트
    private ArrayList<Student> students;

    /**
     * StudentManager 생성자
     * 기존 학생 리스트를 전달받습니다.
     * 
     * @param students 관리할 학생 리스트
     */
    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * 새로운 학생을 추가합니다.
     * 
     * @param student 추가할 학생 객체
     * @return 추가 성공 여부
     */
    public boolean addStudent(Student student) {
        if (student != null) {
            return students.add(student);
        }
        return false;
    }

    /**
     * 지정된 인덱스의 학생을 삭제합니다.
     * 인덱스는 0부터 시작합니다.
     * 
     * @param index 삭제할 학생의 인덱스
     * @return 삭제된 학생 객체 (실패 시 null)
     */
    public Student deleteStudent(int index) {
        if (index >= 0 && index < students.size()) {
            return students.remove(index);
        }
        return null;
    }

    /**
     * 지정된 인덱스의 학생 정보를 업데이트합니다.
     * null 값으로 전달된 필드는 업데이트하지 않습니다.
     * 
     * @param index 수정할 학생의 인덱스
     * @param name 새로운 이름 (null이면 변경 안함)
     * @param age 새로운 나이 (null이면 변경 안함)
     * @param score 새로운 점수 (null이면 변경 안함)
     * @return 수정 성공 여부
     */
    public boolean updateStudent(int index, String name, Integer age, Double score) {
        if (index >= 0 && index < students.size()) {
            Student student = students.get(index);
            
            // null 값이 아닌 필드만 업데이트합니다.
            if (name != null && !name.trim().isEmpty()) {
                student.setName(name);
            }
            if (age != null) {
                student.setAge(age);
            }
            if (score != null) {
                student.setScore(score);
            }
            
            return true;
        }
        return false;
    }

    /**
     * 지정된 인덱스의 학생을 조회합니다.
     * 
     * @param index 조회할 학생의 인덱스
     * @return 학생 객체 (없으면 null)
     */
    public Student getStudent(int index) {
        if (index >= 0 && index < students.size()) {
            return students.get(index);
        }
        return null;
    }

    /**
     * 모든 학생을 조회합니다.
     * 
     * @return 학생 리스트
     */
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    /**
     * 등록된 학생의 총 개수를 반환합니다.
     * 
     * @return 학생 수
     */
    public int getStudentCount() {
        return students.size();
    }

    /**
     * 등록된 학생이 있는지 확인합니다.
     * 
     * @return 학생이 있으면 true, 없으면 false
     */
    public boolean hasStudents() {
        return !students.isEmpty();
    }
}
