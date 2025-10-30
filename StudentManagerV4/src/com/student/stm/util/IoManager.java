package com.student.stm.util;

import java.util.Scanner;

// static 연습을 위해 만듬
public class IoManager {

    private IoManager(){}   // 생성자 제한
    private static Scanner scanner = new Scanner(System.in);
    
    public static String input(String text){
        System.out.print(text);
        return scanner.nextLine();
    }

    public static void print(String text){
        System.out.println(text);
    }

    public static void pause(){
        System.out.println("계속 하시려면 Enter 를 입력하세요");
        scanner.nextLine();
    }
}
