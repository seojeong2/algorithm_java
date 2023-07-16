import java.util.ArrayList;

public class Dijkstra {

    public static final int INF = (int)1e9;

    // 노드의 개수(N), 간선의 개수(M), 시작 노드번호(start)
    public static int n,m,start;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public static void main(String[] args) {



    }
}

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
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
