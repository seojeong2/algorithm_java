package Baekjoon;

import java.util.Scanner;

public class Baekjoon27866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int n = sc.nextInt();

        System.out.println(str.charAt(n-1));
    }
}
