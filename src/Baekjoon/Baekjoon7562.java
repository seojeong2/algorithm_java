package Baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon7562 {

    public static int[][] map;
    public static int l;

    public static int[][] dxdy= {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    public static boolean[][] visited = new boolean[301][301];

    public static int startX, startY, endX, endY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++) {
            l = sc.nextInt();

            map = new int[l+1][l+1];
            startX = sc.nextInt();
            startY = sc.nextInt();

            endX = sc.nextInt();
            endY = sc.nextInt();

            for(int j=0; j<300; j++) {
                Arrays.fill(visited[j], false);
            }

            bfs();

            System.out.println(map[endX][endY]);
        }
    }

    public static void bfs() {
        Queue<Point2> q = new LinkedList<>();
        q.offer(new Point2(startX, startY));
        visited[startX][startY] = true;

        while(!q.isEmpty()) {
            Point2 p = q.poll();
            if(p.x == endX && p.y == endY) break;

            for(int i=0; i<8; i++) {
                int nx = p.x + dxdy[i][0];
                int ny = p.y + dxdy[i][1];

                if(0<=nx && nx <l && 0<=ny && ny <l) {
                    if(!visited[nx][ny] && map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[p.x][p.y] + 1;
                        q.offer(new Point2(nx,ny));
                    }
                }
            }
        }

    }
}

class Point2 {
    public int x;
    public int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
