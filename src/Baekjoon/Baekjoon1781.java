package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] questions = new int[n][2];

        for (int i=0; i<n; i++) {
            String[] tmp = br.readLine().split(" ");
            questions[i][0] = Integer.parseInt(tmp[0]); // 데드라인
            questions[i][1] = Integer.parseInt(tmp[1]); // 컵라면 수
        }

        // 데드라인 기준 오름차순, 컵라면 수 내림차순
        Arrays.sort(questions, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] q:questions) {

            if (pq.size() < q[0]) {
                pq.add(q[1]);
            } else if(pq.size() == q[0]) {
                if (pq.peek() < q[1]) {
                    pq.poll();
                    pq.add(q[1]);
                }
            }
        }

        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);

    }
}
