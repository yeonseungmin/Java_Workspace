import java.nio.channels.Pipe.SourceChannel;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // 주제 : 학생 정보 관리 프로그램
        // 기능 : 학생 정보 등록, 목록, 검색, 삭제, 수정
        // 한 명의 학생의 데이터 : 이름, 나이, 성적

        Scanner scanner = new Scanner(System.in);
        
        // 환영 인사
        System.out.println("==============================");
        System.out.println("       학생 관리 프로그램  V1    ");
        System.out.println("==============================");

        //자료구조
        String[] nameList = new String[5];
        int[] ageList = new int[5];
        int[] gradeList = new int[5];
        int studentCount = 0;

        while(true){
            System.out.println("*** 메뉴 ***");
            System.out.println("1. 학생 정보 등록");
            System.out.println("2. 학생 정보 목록");
            System.out.println("3. 학생 정보 검색");
            System.out.println("4. 학생 정보 삭제");
            System.out.println("5. 학생 정보 수정");    // 학생이름 찾아 점수 나이 변경 기능
            System.out.println("6. 학생 정보 통계");    // 학생 평균 성적, 가장 낮은 점수, 가장 높은 점수
            System.out.println("0. 프로그램 종료");
            System.out.println("\n");

            System.out.print(" 명령어 입력 > ");
            String command = scanner.nextLine();
            
            // 종료 처리
            if(command.equals("0")){
                break;
            }

            
            if(command.equals("1")){
                // 1. 학생 정보 등록
                // 문제 : 나이, 점수 값 유효성 검사 - 숫자가 아닌 경우
                System.out.println(" ### 학생 등록 페이지 ###");
                System.out.print(" 이름 입력 > ");
                String name = scanner.nextLine();


                System.out.print(" 나이 입력 > ");
                
                
                while(!scanner.hasNextInt()){
                    System.out.print("숫자를 다시 입력해주세요 > ");
                    
                    scanner.nextLine();
                }
                String stringAge = scanner.nextLine();
                int age = Integer.parseInt(stringAge);
                
                // 문제 ... stringAge 숫자로만 구성되있는지 확인
                

                
                
                System.out.print(" 성적 입력 > ");
                int grade = Integer.parseInt(scanner.nextLine());

                nameList[studentCount] = name;
                ageList[studentCount] = age;
                gradeList[studentCount] = grade;
                studentCount++;

                // ArrayList
                if(studentCount == nameList.length){
                    //2배 크기의 배열 생성
                    String[] newNameList = new String[studentCount *2];
                    int[] newAgeList = new int[studentCount*2];
                    int[] newGradeList = new int[studentCount*2];
                    //배열 복사
                    for(int i =0; i < studentCount; i++){
                        newNameList[i] = nameList[i];
                        newAgeList[i] = ageList[i];
                        newGradeList[i] = gradeList[i];
                    }
                    nameList = newNameList;
                    ageList = newAgeList;
                    gradeList = newGradeList;
                }

                //문제 : 다음과 같이 입력되었습니다. 정보가 확실합니까? (Y/N)
                System.out.println(" 학생 정보가 등록되었습니다.");
                System.out.println(" ______________________________ ");
                
            }else if(command.equals("2")){
                System.out.println(" ### 학생 목록  ### ");
                // 2. 학생 정보 목록
                // 만약 검색된 학생 정보가 없다면 , 등록된 학생이 없습니다. 출력
                for(int i =0; i < studentCount; i++){
                    String text ="";
                    text +="이름 : "+ nameList[i];
                    text +=", 나이 : "+ ageList[i];
                    text +=", 성적 : "+ gradeList[i];
                    System.out.println(text);
                    
                }
                System.out.println(" 총 "+ studentCount +" 명의 학생이 존재합니다.");
                System.out.println(" ______________________________ ");

            }else if(command.equals("3")){
                // 3. 학생 정보 검색
                System.out.println(" ### 학생 검색 페이지 ###");    
                System.out.println(" 검색할 학생의 이름");
                String searchName = scanner.nextLine();
                int searceCount =0;
                for(int i =0; i< studentCount; i++){
                    if(nameList[i].contains(searchName)){
                        String text = "";
                        text += "이름 : " + nameList[i];
                        text += ", 나이 : " + ageList[i];
                        text += ", 점수: " + gradeList[i];
                        System.out.println(text);
                    }
                }
                System.out.println("총 " + searceCount + "명이 검색되었습니다.");

            }else if(command.equals("4")){
                // 4. 학생 정보 삭제
                System.out.println(" ### 학생 삭제 페이지  ### ");
                System.out.print("삭제할 학생의 이름 > ");
                String deleteName = scanner.nextLine();
                int deleteCount=0;
                for(int i=0; i< studentCount; i ++){
                    if(nameList[i].equals(deleteName)){
                        for(int x =i; x<studentCount-1; x++){
                            nameList[x] = nameList[x+1];
                            ageList[x] = ageList[x+1];
                            gradeList[x] = gradeList[x+1];
                        }
                        studentCount--;
                        deleteCount++;
                        i--;
                    }
                }
                System.out.println("총 " + deleteCount + " 명이 삭제되었습니다.");
            }else if(command.equals("5")){
                // 5. 학생 정보 종료
                System.out.println("[테스트 로그]  5 ");


            }else{
                System.out.println("번호를 잘못 입력하셨습니다.");
                System.out.println("다시 입력 해주시길 바랍니다.");
            }
            System.out.println("계속 진행하시려면 아무키를 입력해주세요");
            scanner.nextLine();

        }   
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
