import java.util.Scanner;

public class Baekjoon1012 {

    public static int n,m,k;
    public static int[][] map;

    public static boolean dfs(int x, int y) {
        if(x<0 || x>=n || y <0 || y>=m) {
            return false;
        }
        if(map[x][y] == 1) {
            map[x][y] = 0;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y+1);
            dfs(x,y-1);

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int w=0; w<t; w++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            map = new int[n+1][m+1];

            for(int i=0; i<k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                map[b][a] = 1;
            }

            int count = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(dfs(i,j)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
