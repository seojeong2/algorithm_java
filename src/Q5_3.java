import java.util.Scanner;

public class Q5_3 {
    public static int n,m;
    public static int[][] map = new int[1001][1001];

    public static boolean dfs(int x, int y) {
        if(x < 0 || x >= n || y<0 || y>=m) {
            return false;
        }

        if(map[x][y] == 0) {
            map[x][y] = 1;

            // 상,하,좌,우 재귀적 호출로 확인
            dfs(x,y+1);
            dfs(x,y-1);
            dfs(x-1,y);
            dfs(x+1,y);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 버퍼지우기

        for(int i=0; i<n; i++) {
            String str = sc.nextLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        int result = 0;
        // 모든 노드(위치)에 대해서 탐색
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(i,j)) {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
