package p4;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class App {
    public static void main(String[] args) throws Exception {
        //bmp 기준의 파일 생성
        //파일명: aaa.bmp
        //해상도 : 100x100

        File file = new File("C:\\Temp\\aaa.bmp");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeByte('B');
        dos.writeByte('M');
        dos.writeByte(30054 >> 24);
        dos.writeByte(30054 >> 16);
        dos.writeByte(30054 >> 8);
        dos.writeByte(30054 >> 0);

        for(int x =0; x<100; x++){
            for(int y =0; y<100; y++){
                dos.writeByte(0xFF);
                dos.writeByte(0xFF);
                dos.writeByte(0xFF);
            }
        }

        dos.close();
        bos.close();
        fos.close();




    }
}
