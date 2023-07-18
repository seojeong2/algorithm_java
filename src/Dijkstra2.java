import java.net.SecureCacheResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra2 {

    public static final int INF = (int)1e9;

    // 노드의 개수:n, 간선의 개수:m, 시작 노드번호: start
    public static int n,m,start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();

    // 방문체크 배열
    public static boolean[] visited = new boolean[100001];
    // 최단거리 테이블
    public static int[] d = new int[100001];

    // 방문하지 않은 노드 중에서, 가장 최단거리가 짧은 노드의 번호를 반환
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
        // 시작 노드 초기화
        d[start] = 0;
        visited[start] = true;

        for(int j=0; j<graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        // 시작 노드제외 전체 n-1개의 노드에 대해서 반복
        for(int i=0; i<n-1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for(int j=0; j<graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                // 현재 노드를 거쳐서 다른 노드를 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        start = sc.nextInt();

        // 그래프초기화
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Node2>());
        }

        // 모든 간선 정보 입력받기
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node2(b,c));
        }
        // 최단거리 테이블 무한으로 초기화
        Arrays.fill(d,INF);
        // 다익스트라 알고리즘 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리 출력
        for(int i=1; i<=n; i++) {
            if(d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}

class Node2 {
    public int index;
    public int distance;

    public Node2(int index, int distance) {
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
