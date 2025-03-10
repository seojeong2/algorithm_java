package Baekjoon;

import java.util.Scanner;

import static java.lang.System.exit;

public class Baekjoon4963 {

    public static int w,h;
    public static int[][] map;

    public static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h+1][w+1];
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int count = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(dfs(i,j)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        exit(0);

    }
    public static boolean dfs(int x, int y) {
        if(x < 0 || x>=h || y <0 || y>= w) {
            return false;
        }
        if(map[x][y] == 1) {
            map[x][y] = 0;

            // 방향 재귀 탐색
            dfs(x,y+1);
            dfs(x,y-1);
            dfs(x+1,y);
            dfs(x-1,y);
            dfs(x-1,y-1);
            dfs(x-1,y+1);
            dfs(x+1,y-1);
            dfs(x+1,y+1);

            return true;
        }
        return false;
    }
}

