package p9;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("클라이언트 시작");

        System.out.println("서버 접속 시도");
        Socket socket = new Socket("172.30.1.71",7777);   // 접속 시도 코드

        while(true){
            
        System.out.print("전달 값 입력 (0. 종료)>");
        String masage = scanner.nextLine();
        
        if(masage.equals("0"))break;
        DataOutputStream dos = new DataOutputStream((socket.getOutputStream()));
        dos.writeUTF(masage);
        System.out.println("서버에 메시지 전달완료");    
        }   



        System.out.println("클라이언트 종료");
    }
}
