import java.util.*;

public class Q17_39 {

    public static final int INF = (int)1e9;
    public static int n;
    public static int[][] map;
    public static int[][] distance;
    public static int[][] dxdy = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int w = 0; w<T; w++) {
            n = sc.nextInt();

            map = new int[n+1][n+1];
            distance = new int[n+1][n+1];


            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<n; i++) {
                Arrays.fill(distance[i], INF);
            }

            int x = 0, y=0;
            PriorityQueue<Position> pq = new PriorityQueue<>();
            pq.offer(new Position(x,y,map[x][y]));
            distance[x][y] = map[x][y];

            while(!pq.isEmpty()) {
                Position p = pq.poll();
                int dist = p.distance;
                x = p.x;
                y = p.y;

                if(distance[x][y] < dist) continue;
                for(int i=0; i<4; i++) {
                    int nx = x + dxdy[i][0];
                    int ny = y + dxdy[i][1];

                    if(nx < 0 || nx >=n || ny < 0 || ny >=n) continue;
                    int cost = dist + map[nx][ny];

                    if(cost < distance[nx][ny]) {
                        distance[nx][ny] = cost;
                        pq.offer(new Position(nx,ny,cost));
                    }

                }
            }
            System.out.println(distance[n-1][n-1]);
        }
    }


}

class Position implements Comparable<Position>{
    public int x;
    public int y;
    public int distance;

    public Position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Position o) {
        if(this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}
