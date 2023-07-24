import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra7 {
    public static final int INF = (int)1e9;

    public static int n,m,start;
    public static int d[];

    public static ArrayList<ArrayList<Node7>> map = new ArrayList<ArrayList<Node7>>();

    public static void dijkstra(int start) {
        PriorityQueue<Node7> pq = new PriorityQueue<>();
        pq.offer(new Node7(start,0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node7 n = pq.poll();

            int dist = n.distance;
            int now = n.index;

            if(d[now] < dist) continue; // 이미 방문
            for(int i=0; i<map.get(now).size(); i++) {
                int cost = dist + map.get(now).get(i).distance;

                if(cost < d[map.get(now).get(i).index]) {
                    d[map.get(now).get(i).index] = cost;
                    pq.offer(new Node7(map.get(now).get(i).index, cost));
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
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<Node7>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            map.get(a).add(new Node7(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }
    }
}

class Node7 implements Comparable<Node7> {
    public int index;
    public int distance;

    public Node7(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node7 o) {
        if(this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}
