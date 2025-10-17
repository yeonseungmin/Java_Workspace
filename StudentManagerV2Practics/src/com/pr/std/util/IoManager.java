package com.pr.std.util;

import java.util.Scanner;

// static 연습을 위해 만듬
public class IoManager {
     private IoManager(){}
     private static Scanner scanner = new Scanner(System.in);

     public static String input(String text){
        System.out.println(text);
        return scanner.nextLine();
     }

     public static void print(String text){
        System.out.println(text);
     }

     public static void pause(){
        System.out.println("일시정지 Enter");
        scanner.nextLine();
     }

}
