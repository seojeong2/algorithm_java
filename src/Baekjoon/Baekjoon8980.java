package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon8980 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 마을 수
        int c = Integer.parseInt(input[1]); // 트럭 용량

        int m = Integer.parseInt(br.readLine()); // 박스의 개수

        int[][] priority = new int[m][3];

        // input
        for (int i=0; i<m; i++) {
            String[] inputData = br.readLine().split(" ");

            priority[i][0] = Integer.parseInt(inputData[0]);
            priority[i][1] = Integer.parseInt(inputData[1]);
            priority[i][2] = Integer.parseInt(inputData[2]);
        }
        // 보내는 마을 오름차순, 받는마을 오름차순
        Arrays.sort(priority,(x,y) -> {
            if (x[1] == y[1]) {
                return x[0] - y[0];
            }
            return x[1] - y[1];
        });

        int[] capacities = new int[n+1];
        for(int i=1; i<n; i++) {
            capacities[i] = c;
        }

        int ans = 0;
        for(int i=0; i<priority.length; i++ ){
            int start = priority[i][0];
            int end = priority[i][1];
            int box = priority[i][2];

            int capacity = Integer.MAX_VALUE;

            for (int j=start; j<end; j++) {
                capacity = Math.min(capacity,capacities[j]);
            }

            for (int j=start; j<end; j++) {
                capacities[j] -= Math.min(capacity, box);
            }
            ans += Math.min(capacity,box);
        }
        System.out.println(ans);

    }


}
