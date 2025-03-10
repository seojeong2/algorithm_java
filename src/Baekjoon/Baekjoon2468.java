package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2468 {
    public static int n;
    public static int[][] map;
    public static boolean[][] check;
    public static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int count=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n+1][n+1];
        check= new boolean[n+1][n+1];

        int min = 100;
        int max = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] > max) max = map[i][j];
                if(map[i][j] < min) min = map[i][j];
            }
        }

        int result = 1;
        for(int i=min; i<max; i++) {
            count = 0;
            for(int j=0; j<n; j++) {
                Arrays.fill(check[j],false);
            }

            for(int a=0; a<n; a++) {
                for(int b=0; b<n; b++) {
                    if(!check[a][b] && map[a][b] > i) {
                        dfs(a,b,i);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    public static void dfs(int x, int y, int height) {
        if(x<0 || x >=n || y <0 || y>= n) { // 범위 벗어나면
            return;
        }
        if(check[x][y] || map[x][y] <= height) {
            return;
        }

        check[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dxdy[i][0];
            int ny = y + dxdy[i][1];

            dfs(nx,ny,height);
        }
    }
}
