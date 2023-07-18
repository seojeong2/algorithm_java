import java.util.ArrayList;

public class Dijkstra5 {

    public static final int INF = (int)1e9;
    public static int n,m,start;
    public static ArrayList<ArrayList<Node5>> graph = new ArrayList<ArrayList<Node5>>();
    public static boolean[] visited = new boolean[100001];
    public static int[] d = new int[100001];

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

    public static void dijkstra(int start) {
        d[start] = 0;
        visited[start] = true;

        for(int j=0; j<graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = d[graph.get(start).get(j).getDistance()];
        }

        for(int i=0; i<n-1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for(int j=0; j<graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                if(cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

class Node5 {
    public int index;
    public int distance;

    public Node5(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}
