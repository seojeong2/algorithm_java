import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_v2 {

    public static final int INF = (int)1e9;
    public static int n,m,start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기위한 최단 비용을 0으로 설정하여 pq에 넣음
        pq.offer(new Node(start,0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            // 현재노드가 이미 처리된적 있는 노드라면 무시
            if(d[now] < dist) continue;

            // 현재 노드와 연결된 다른 노드들을 확인
            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(),cost));
                }
            }
        }
   }

    public static void main(String[] args) {

    }
}
