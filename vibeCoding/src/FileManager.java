import java.io.*;        // 파일 입출력을 위한 패키지 import
import java.util.ArrayList;  // ArrayList 사용을 위한 import

/**
 * FileManager 클래스
 * 학생 정보를 파일에 저장하고 파일에서 로드하는 기능을 담당합니다.
 * CSV(Comma-Separated Values) 형식으로 파일을 관리합니다.
 * 파일 형식: 이름,나이,점수
 */
public class FileManager {
    // 학생 정보를 저장할 기본 파일명
    // static final: 프로그램 전체에서 공유하며 변경 불가능한 상수
    private static final String FILE_NAME = "students.csv";

    /**
     * saveStudents 메서드
     * ArrayList에 저장된 모든 학생 정보를 파일에 저장합니다.
     * 기존 파일이 있으면 덮어쓰기 합니다.
     * 파일 형식: 학번,이름,나이,점수,학년,등록일
     * 
     * @param students 저장할 학생 정보가 담긴 ArrayList
     * @return 저장 성공 여부 (true: 성공, false: 실패)
     */
    public static boolean saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            
            // 헤더 작성
            writer.write("studentId,name,age,score,grade,enrollmentDate");
            writer.newLine();
            
            // ArrayList의 모든 학생을 순회하며 파일에 저장
            for (Student student : students) {
                // Student 객체에서 정보를 가져와 CSV 형식으로 작성
                String line = student.getStudentId() + "," + 
                             student.getName() + "," + 
                             student.getAge() + "," + 
                             student.getScore() + "," +
                             student.getGrade() + "," +
                             student.getEnrollmentDate();
                
                writer.write(line);
                writer.newLine();
            }
            
            System.out.println("✓ 파일 저장 완료: " + FILE_NAME);
            return true;
            
        } catch (IOException e) {
            System.out.println("✗ 파일 저장 실패: " + e.getMessage());
            return false;
        }
    }

    /**
     * loadStudents 메서드
     * 파일에서 학생 정보를 읽어서 ArrayList에 로드합니다.
     * 파일이 없으면 빈 ArrayList를 반환합니다.
     * 파일 형식: 학번,이름,나이,점수,학년,등록일
     * 
     * @return 로드된 학생 정보가 담긴 ArrayList
     */
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            System.out.println("✓ 새로운 파일로 시작합니다.");
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            
            // 헤더 라인 건너뛰기
            reader.readLine();
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                
                String[] parts = line.split(",");
                
                // 새 형식: studentId,name,age,score,grade,enrollmentDate (6개)
                // 구 형식: name,age,score (3개) - 하위 호환성
                if (parts.length >= 3) {
                    try {
                        String name;
                        int age;
                        double score;
                        
                        if (parts.length == 6) {
                            // 새 형식
                            name = parts[1];
                            age = Integer.parseInt(parts[2]);
                            score = Double.parseDouble(parts[3]);
                        } else {
                            // 구 형식 (호환성)
                            name = parts[0];
                            age = Integer.parseInt(parts[1]);
                            score = Double.parseDouble(parts[2]);
                        }
                        
                        Student student = new Student(name, age, score);
                        students.add(student);
                        
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ 잘못된 데이터 형식 (건너뜀): " + line);
                    }
                }
            }
            
            if (students.size() > 0) {
                System.out.println("✓ 파일 로드 완료: " + FILE_NAME + " (" + students.size() + "명)");
            }
            
        } catch (IOException e) {
            System.out.println("✗ 파일 로드 실패: " + e.getMessage());
        }
        
        return students;
    }

    /**
     * getFileName 메서드
     * 저장되는 파일명을 반환합니다.
     * 
     * @return 파일명 (students.csv)
     */
    public static String getFileName() {
        return FILE_NAME;
    }
}
