package p9;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws Exception{
        System.out.println("서버 시작");
        ServerSocket serverSocket = new ServerSocket(7777);

        while(true){
            Socket socket = serverSocket.accept();// 클라이언트로부터 접속대기
            System.out.println(socket.getInetAddress().getHostAddress()+"가 접속했습니다.");

            new RecvThread(socket).start();
        }

        // System.out.println("클라이언트 접속 대기");
        // Socket socket = serverSocket.accept();// 클라이언트로부터 접속대기
        // System.out.println( " 누군가 접속 했음 "+ socket.getRemoteSocketAddress());
        
        // DataInputStream dis = new DataInputStream(socket.getInputStream());
        // String message = dis.readUTF();
        // System.out.println("클라이언트로 부터 전달 받은값 : "+ message);
        



        // System.out.println("서버 종료");
    }
}

class RecvThread extends Thread{
    private Socket socket;
    public RecvThread(Socket socket){
        this. socket = socket;
    }
    @Override
    public void run(){
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String ip = socket.getInetAddress().getHostAddress();    
            while (true) {
                String message = dis.readUTF();
                System.out.println(ip +" 메세지 :"+ message);
            }
        } catch (Exception e) {
            System.out.println("누군가");
            // TODO: handle exception
        }
        
    }
}