package Baekjoon;

import java.util.Scanner;

public class Baekjoon18406 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int len = str.length();

        int num1 = 0;
        int num2 = 0;

        String str1 = str.substring(0,len/2);
        String str2 = str.substring(len/2,len);

        for(int i=0; i<str1.length(); i++) {
            num1 += str1.charAt(i) - '0';
        }
        for(int i=0; i<str2.length(); i++) {
            num2 += str2.charAt(i) - '0';
        }

        System.out.println(num1 == num2 ? "LUCKY" : "READY");

    }
}
