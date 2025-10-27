package p7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class App {
    public static void main(String[] args) {    //Unhandled  뜨면 try catch 해라
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:/aaa/bbb/ccc.text");
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();    
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                
            }
        try(FileOutputStream fileOutputStream2 = new FileOutputStream("C:/aaa/bbb/ccc.text")){     
        } catch (Exception e) {         //위 코드를 최신식으로 줄인 것***********
            // TODO: handle exception
        }
        

        int value = Integer.parseInt("19");
        try {
            Socket socket = new Socket("111.111.111.111",8000);
        } catch (ArithmeticException e) {
            // TODO: handle exception
        } catch (UnknownHostException e) {
            // TODO: handle exception
        } catch (IOException e) {
            // TODO: handle exception
        }
    }
    
}
}
