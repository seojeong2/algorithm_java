import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

    public static final int INF = (int)1e9;
    public static int n,m;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];

        // 최단거리 테이블 모두 초기화
        for(int i=0; i<n+1; i++) {
            Arrays.fill(graph[i],INF);
        }
        // 자기 자신으로 가는 비용은 0으로 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) graph[i][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a][b] = c;
        }

        // 점화식에 따라 플로이드 알고리즘 수행
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
                if (graph[a][b] == INF) {
                    System.out.print("INFINITY ");
                }
                // 도달할 수 있는 경우 거리를 출력
                else {
                    System.out.print(graph[a][b] + " ");
                }
            }
            System.out.println();
        }

    }
}
