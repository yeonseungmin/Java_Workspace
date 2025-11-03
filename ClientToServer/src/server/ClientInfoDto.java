package server;

import java.net.Socket;
public class ClientInfoDto {
    public String nickName;
    public Socket socket;

    public ClientInfoDto(String nickname, Socket socket){
        this.nickName = nickname;
        this.socket = socket;
    }
}
