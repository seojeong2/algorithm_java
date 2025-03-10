package Baekjoon;

import java.util.Scanner;

public class Baekjoon9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {
            String answer="";
            String str = sc.nextLine();
            answer += str.charAt(0);
            answer += str.charAt(str.length()-1);

            System.out.println(answer);
        }



    }
}
