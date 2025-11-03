package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ServerReceiveMessageThread extends Thread{
    private final ClientInfoDto clientInfoDto;    // 보낸사람
    public ServerReceiveMessageThread(ClientInfoDto clientInfoDto){
        this.clientInfoDto = clientInfoDto;
    }   
    
    @Override
    public void run(){
        try (clientInfoDto.socket) {
            String helloMessage = clientInfoDto.nickName + " 님이 접속하셨습니다.";
            broadcast(helloMessage);

            DataInputStream dis = new DataInputStream(clientInfoDto.socket.getInputStream());

            while (true) {
                String message = dis.readUTF();
                
                String forSendMessage = clientInfoDto.nickName +" > ";
                forSendMessage += message;
                broadcast(forSendMessage);
            }

        } catch (Exception e) {
            ClientInfoListManager.list.remove(clientInfoDto);
            String message = clientInfoDto.nickName + " 님이 퇴장하셨습니다.";
            broadcast(message);
        }

    }

    private void broadcast(String message){
        // 브로드 캐스팅    A를 포함한 모든 접속자에게 메세지 전달.
        System.out.println("[서버로그] "+ message); 
                for(ClientInfoDto element : ClientInfoListManager.list){    //element 받는사람
                    try {
                        DataOutputStream dos = new DataOutputStream(element.socket.getOutputStream());// 원래라면 클라이언트쪽에서 처리하고 넘어오는게 낫다.
                        dos.writeUTF(message);   
                        
                    } catch (Exception e) {     // A 가 나감과 동시에 전체 전송 리스트를 로드하는과정에서 Exception
                        System.out.println("서버 예외");
                    }
                }
    }
}
