import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra3 {

    public static final int INF = (int)1e9;

    public static int n,m,start;

    public static ArrayList<ArrayList<Node3>> graph = new ArrayList<ArrayList<Node3>>();

    public static boolean[] visited = new boolean[100001];
    public static int[] d = new int[100001];

    // 빙문하지 않은 노드중에서, 가장 거리가 짧은 노드의 번호를 반환
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;

        for(int i=1; i<=n; i++) {
            if(d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    // 다익스트라 알고리즘 수행
    public static void dijkstra(int start) {
        d[start] = 0;
        visited[start] = true;

        for(int j=0; j<graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드를 제외한 전체 n-1개의 노드에 대해서 반복
        for(int i=0; i<n-1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            // 현재 노드와 연결된 다른 노드를 확인
            for(int j=0; j<graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                if(cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Node3>());
        }

        // 모든 간선 정보 입력받기
        for (int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node3(b,c));
        }

        // 최단거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d,INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);
    }
}
class Node3 {
    public int index;
    public int distance;

    public Node3(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }
    public int getDistance() {
        return this.distance;
    }
}
