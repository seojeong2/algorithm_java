package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11501 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] tmp = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(tmp[j]);
            }
            long sum = 0;
            long maxPrice = 0;

            for (int k=n-1; k>=0; k--) {
                if (arr[k] > maxPrice) {
                    maxPrice = arr[k];
                } else {
                    sum += (maxPrice - arr[k]);
                }
            }
            System.out.println(sum);
        }

    }
}
