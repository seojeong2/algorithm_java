import java.util.Scanner;

public class Baekjoon1463 {

    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n+1];

        System.out.println(solve(n));

    }

    public static int solve(int n) {
        if(n==1) return 0;
        if(dp[n] > 0) return dp[n];

        dp[n] = solve(n-1) + 1;
        if(n%2 == 0) {
            int temp = solve(n/2) + 1;
            if(dp[n] > temp) {
                dp[n] = temp;
            }
        }

        if(n%3 == 0) {
            int temp = solve(n/3) + 1;
            if(dp[n] > temp) {
                dp[n] = temp;
            }
        }
        return dp[n];
    }
}
