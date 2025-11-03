package client;

import java.io.DataInputStream;
import java.net.Socket;

public class ClientReceiveMessageThread extends Thread {    // 입력대기중에도 다른 채팅은 진행되기에 쓰레드 사용
    private Socket socket;
    public ClientReceiveMessageThread(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            while (true) {
                String message =dis.readUTF();
                System.out.println(message);
            }

        } catch (Exception e) {
            
        }
    }
}
