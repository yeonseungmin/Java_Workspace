package StudentManager.App;

import StudentManager.actioncommand.ActionCommand;
import StudentManager.menu.Menu;
import StudentManager.repository.StudentRepository;


import java.util.Scanner;

public class StudentManagementApp {

    
    
    // 이 클래스에서 학생 데이터를 관리한다고 가정
    // 예시를 위해 간단한 로직만 구현합니다.
    private static Scanner scanner = new Scanner(System.in);
    private static StudentRepository repository = new StudentRepository();

    // 학생 등록
    private static void registerStudent() {
        boolean check = true;
        System.out.println("--- [학생 등록 기능] : 이름, 학번 등을 입력받아 저장");
        System.out.print("이름 입력 > ");
        String name = scanner.nextLine();
        System.out.print("학번 입력 > ");
        while(check){
            if(!scanner.hasNextInt()){  // 학번을 0을 연속으로 넣을시 0 하나만 출력..문제..
                System.out.println("[숫자가 아닙니다.]");
                System.out.print("학번을 입력해주세요 >");
                scanner.nextLine();
            }else{
                check=false;
            }
        }
        int studentId = Integer.parseInt(scanner.nextLine());
        repository.save(name, studentId);

        // 실제 학생 객체 생성 및 리스트에 추가 로직 구현
    }

    private static void searchStudent() {
        System.out.println("--- [학생 정보 검색 기능] : 검색 조건에 맞는 학생 정보 출력");
        System.out.print("검색할 이름 입력 > ");
        String name = scanner.nextLine();
        repository.findStudent(name);
    }

    private static void inputGrade() {
        System.out.println("--- [성적 입력 기능] : 특정 학생의 과목별 성적 입력");
    }

    private static void viewGrade() {
        System.out.println("--- [성적 조회 기능] : 학생별/과목별 성적 리포트 출력");
    }

    public static void main(String[] args) {
        // ----------------------------------------------------
        // 1. 최하위 레벨 (ActionCommand) 정의: 실제 기능
        // ----------------------------------------------------
        
        // 학생 관리 하위 기능
        ActionCommand register = new ActionCommand("학생 등록", StudentManagementApp::registerStudent);
        ActionCommand search = new ActionCommand("학생 정보 검색", StudentManagementApp::searchStudent);

        // 성적 관리 하위 기능
        ActionCommand inputG = new ActionCommand("성적 입력", StudentManagementApp::inputGrade);
        ActionCommand viewG = new ActionCommand("성적 조회", StudentManagementApp::viewGrade);

        // ----------------------------------------------------
        // 2. 중간 레벨 (Menu) 정의: 2단계 메뉴
        // ----------------------------------------------------
        
        Menu studentMenu = new Menu("학생 관리");
        studentMenu.add(register);
        studentMenu.add(search);

        Menu gradeMenu = new Menu("성적 관리");
        gradeMenu.add(inputG);
        gradeMenu.add(viewG);

        // ----------------------------------------------------
        // 3. 최상위 레벨 (Menu) 정의: 메인 메뉴
        // ----------------------------------------------------
        
        Menu mainMenu = new Menu("학생 관리 시스템 메인");
        mainMenu.add(studentMenu); // 2단계 메뉴를 1단계 메뉴에 추가
        mainMenu.add(gradeMenu);   // 2단계 메뉴를 1단계 메뉴에 추가
        // 종료 기능은 ActionCommand를 특별히 구현하거나, Menu 클래스 내부의 0번 로직을 사용합니다.
        
        // ----------------------------------------------------
        // 4. 프로그램 시작
        // ----------------------------------------------------
        System.out.println("== 학생 관리 프로그램 시작 ==");
        mainMenu.execute(); 
        System.out.println("== 학생 관리 프로그램 종료 ==");
    }
}





