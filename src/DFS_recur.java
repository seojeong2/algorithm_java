import java.util.ArrayList;
import java.util.Arrays;

public class DFS_recur {

    public static boolean[] visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int x) {
        visited[x] = true;
        System.out.println(x+" ");

        for(int i=0; i<graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if(!visited[y]) dfs(y);
        }
    }

    public static void main(String[] args) {

        for(int i=0; i<9; i++) {
            graph.add(new ArrayList<>());
        }

        // 각 노드마다 연결된 노드정보 전달
    }
}
