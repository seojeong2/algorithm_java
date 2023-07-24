import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Scanner;

public class Q17_37 {

    public static final int INF = (int)1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n+1][n+1];

        for(int i=0; i<n; i++) {
            Arrays.fill(map[i],INF);
        }

        // 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) map[i][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            map[a][b] = Math.min(map[a][b],c);
        }

        for(int k=1; k<=n; k++) {
            for(int a=1; a<=n; a++) {
                for(int b=1; b<=n; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(map[i][j] == INF) {
                    System.out.println(0+" ");
                } else {
                    System.out.print(map[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}
