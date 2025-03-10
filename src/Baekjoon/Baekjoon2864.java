package Baekjoon;

import java.util.Scanner;

public class Baekjoon2864 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int min = Integer.parseInt(Integer.toString(num1).replaceAll("6","5")) +
                Integer.parseInt(Integer.toString(num2).replaceAll("6","5"));

        int max = Integer.parseInt(Integer.toString(num1).replaceAll("5","6")) +
                Integer.parseInt(Integer.toString(num2).replaceAll("5","6"));

        System.out.println(min+" "+ max);
    }
}
