package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Baekjoon2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        Arrays.stream(sortedNums).forEach(System.out::println);

        sc.close();
    }



}
