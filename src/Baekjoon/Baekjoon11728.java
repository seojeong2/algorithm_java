package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class Baekjoon11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] answer = new int[n+m];
        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");

        int idx = 0;
        for(int i=0; i<str1.length; i++) {
            answer[idx++] = Integer.parseInt(str1[i]);
        }
        for(int i=0; i<str2.length; i++) {
            answer[idx++] = Integer.parseInt(str2[i]);
        }
        Arrays.sort(answer);
        for (int i : answer) {
            bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
        bw.close();

    }
}
