//package Baekjoon;
//
//import java.awt.*;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Baekjoon2178 {
//    public static int n,m;
//    public static int[][] map = new int[101][101];
//
//    public static int[][] dxdy = {{-1,0},{0,1},{1,0},{0,-1}};
//
//    public static int bfs(int x, int y) {
//
//        Queue<Point> q = new LinkedList<>();
//        q.offer(new Point(x,y));
//
//        while(!q.isEmpty()) {
//            Point point = q.poll();
//            x = point.getX();
//            y = point.getY();
//
//            for(int i=0; i<4; i++) {
//                int nx = x + dxdy[i][0];
//                int ny = y + dxdy[i][1];
//
//                if(nx < 0 || nx >= n || ny < 0 || ny >= m ) continue;
//                if(map[nx][ny] == 0) continue;
//
//                if(map[nx][ny] == 1) {
//                    map[nx][ny] = map[x][y] + 1;
//                    q.offer(new Point(nx,ny));
//                }
//            }
//        }
//
//        return map[n-1][m-1];
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        sc.nextLine();
//
//        for(int i=0; i<n; i++) {
//            String str = sc.nextLine();
//            for(int j=0; j<m; j++) {
//                map[i][j] = str.charAt(j) - '0';
//            }
//        }
//
//        System.out.println(bfs(0,0));
//    }
//}
