package Baekjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2606 {
    public static int n,m;
    public static int[][] map;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = 1;
            map[b][a] = 1;
        }
        Arrays.fill(visited,false);
        System.out.println(bfs(1));
    }

    public static int bfs(int x) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int i=1; i<=n; i++) {
                if(map[v][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
