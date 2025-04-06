package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1911 {

    static class Puddle implements Comparable<Puddle> {
        int start, end;

        public Puddle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Puddle o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 웅덩이 수
        int L = Integer.parseInt(st.nextToken()); // 널빤지 길이

        Puddle[] puddles = new Puddle[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            puddles[i] = new Puddle(s, e);
        }

        Arrays.sort(puddles); // 시작점 기준 정렬

        int count = 0;
        int lastCovered = 0;

        for (Puddle p : puddles) {
            int start = Math.max(p.start, lastCovered);
            if (start >= p.end) continue;

            int length = p.end - start;
            int boardCount = (length + L - 1) / L; // ceil(length / L)
            count += boardCount;
            lastCovered = start + boardCount * L;
        }

        System.out.println(count);
    }

}
