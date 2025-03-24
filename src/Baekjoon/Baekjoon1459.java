package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1459 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long x = Integer.parseInt(input[0]);
        long y = Integer.parseInt(input[1]);
        long w = Integer.parseInt(input[2]);
        long s = Integer.parseInt(input[3]);

        // 1. 평행이동만 하는 경우
        long case1 = (x + y) * w;

        // 2. 대각선으로 최대한 이동
        long case2 = Math.min(x,y) * s + Math.abs(x-y) * w;

        // 3. 대각선으로만 이동
        // 3-1) x + y 가 짝수인 경우 대각선으로만 이동 가능
        // 3-2) x + y 가 홀수인 경우 반드시 평행이동 한번이 있기 때문에 마지막 대각선 카운트 하지 않고 평행이동 추가
        long case3 = (x+y) % 2 ==0 ? Math.max(x,y) * s : (Math.max(x,y) -1) * s + w;

        System.out.println(Math.min(Math.min(case1,case2),case3));
    }
}
