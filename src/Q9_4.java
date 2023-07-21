import java.util.Arrays;
import java.util.Scanner;

public class Q9_4 {

    public static final int INF = (int)1e9;
    public static int n,m;
    public static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        for(int i=0; i<n; i++) {
            Arrays.fill(graph[i],INF);
        }

        // 자기 자신으로 가는 비용 초기화
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i==j) graph[j][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int x = sc.nextInt(); // 거쳐갈 노드
        int k = sc.nextInt(); // 최종 목적지

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int w=1; w<=n; w++) {
                    graph[j][w] = Math.min(graph[j][w], graph[j][i] + graph[i][w]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if(distance == INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}
