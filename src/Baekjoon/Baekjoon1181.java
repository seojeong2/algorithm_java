package Baekjoon;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1181 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] data = new String[n];

        for (int i=0; i<n; i++) {
            data[i] = br.readLine();
        }

        String[] sortedArr =  Arrays.stream(data).distinct().sorted((s1,s2)-> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            return s1.compareTo(s2);
        }).toArray(String[]::new);

        Arrays.stream(sortedArr).forEach(System.out::println);
    }
}
