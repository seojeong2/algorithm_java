package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2752 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] d = new int[3];

        for(int i=0; i<3; i++) {
            d[i] = sc.nextInt();
        }
        Arrays.sort(d);

        for (int i : d) {
            System.out.print(i+" ");
        }
    }
}
