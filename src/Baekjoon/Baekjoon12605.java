package Baekjoon;

import java.util.Scanner;

public class Baekjoon12605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++){
            String answer = "";
            String str = sc.nextLine();

            String[] arr = str.split(" ");

            for(int j=arr.length-1; j>=0; j--) {
                answer += arr[j];
                answer += " ";
            }
            System.out.println("Case #" + (i+1) +": " + answer);
        }
    }
}
