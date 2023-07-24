import java.util.Scanner;

public class Baekjoon11403 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for(int k=0; k<n; k++) {
            for(int a=0; a<n; a++) {
                for(int b=0; b<n; b++) {
                    if(map[a][k] == 1 && map[k][b] == 1) {
                        map[a][b] = 1;
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
