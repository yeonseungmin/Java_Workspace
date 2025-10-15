import java.security.cert.TrustAnchor;

import javax.swing.plaf.TreeUI;

public class P2 {
    public static void main(String[] args) {
        // 변수의 선언
        // "타입 변수명 = 초기값"
        // int a = 10 
        boolean a = true;
        // 같은 이름의 변수명 중복 '선언' 불가
        int a1 = 1; // int a = 1;
        int a2 = 2; // int a = 2;
        a1 = 2;     // 대입 문법

        // 변수명은 가독성이 좋게 지어야 한다.
        // 소문자로 시작 대문자로 구분. 's'core'N'umber - 카멜케이스
        
        
    }
    public static void Number(String[] args) {
        // 기본 타입 (primitive type) 종류
        // 정수  : byte, short, int, long
        byte a = 10;        // 8 bit = 1 byte       256
        short b = 10;       // 16 bit = 2 byte      65536
        int c = 10;         // 32 bit = 4 byte      대충 40억
        long d = 10;        // 64 bit = 8 byte      매우 큼
        double e = 10;
        
    }
    
    public static void Standard(String[] args) {
        int a = 10; // int a = "10";
        a = 0xFF;   
        int b = 0b00001010; // =10
        a = 0xA;            // b bit, x 16진수 0~9 A~F
        
        long f = 1000; // 정확히는 타입 미스 매칭
        long g = 1000000000;    // 20억을 넘어서는 순간 문법오류  20000000000'L'문법

    }

    public static void naturalNumber(String[] args) {
        // 실수 타입 : float, double(실제 사용)
        // 정밀도 차이 float < double
        double a = 10.1;        // 64bit = 8byte
        float b = 10.3f;        // 32bit = 4byte
        double e = 0.0000000002;
        e = 2e-8;   //2 * 10^(-8)
    }

    public static void String(String[] args) {
        // 문자 타입 (주의 : 사실상 숫자 타입)
        // char

        char c = '안';      // ' ' = 문자 , " " = 문자열

        byte a = 'A';
        System.out.println(a);     // ASCII 상 A = 65 출력
        String b = "안농하세요";    // String은 기본타입이 아닌 클래스 명 
    }

    public static void Boolean(String[] args) {
        // 논리타입 : boolean 1byte
        // true, false 만 담을 수 있음
        // 사용처 -> if, while 등 간접적으로 사용
        boolean a = true;
    }

    public static void Type(String[] args) {
        // 타입 미스매치 -> 프로모션, 캐스팅

        byte a = 10;
        int b = 20;
        boolean c = true;

        // a = c;   (TypeMissMatch)
        // c = a;   (TypeMissMatch)
        // a = b;   (TypeMissMatch)     큰 범위의 값을 작은 범위의 값으로 이동불가
        b = a;       // 타입이 달라 프로모션 발생.   ㄴbyte에 20은 들어가지만 최대치인 20억이 들어가기 힘듬
        a = (byte)b;    // 명시적 형변환 **********************************************************

        double v1 = 10;         //프로모션 10.0
        int v2 = (int)30.0;     //강제 형변환

        float f1 = 10.0f;
        long f2 = 9012830148156L;

        f1 = f2;        // float 4byte long 8byte
        f2 = (long)f1;  //                  ㄴ float은 근사치의 값이라 

        int t1 = 65;
        char t2 = 65;   // A
        char t3 = '안'; 


    }
}
