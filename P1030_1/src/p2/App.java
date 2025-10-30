package p2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.runtime.TemplateRuntime;


public class App {
    public static void main(String[] args) throws Exception{
        //파일 입출력 .. 쓰레드.. 네트워크...

        //파일 입출력 : 데이터를 파일에 저장 할 수 있다.
        
        int a = 10;
        System.out.println(a);
        File file = new File("C:\\Temp\\aaa.dat");

        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        
        dos.writeInt(10);
        dos.writeUTF("안농");
        dos.close();
        bos.close();
        fos.close();


    }
}
