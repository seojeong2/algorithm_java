import java.util.Scanner;

public class Baekjoon5988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            System.out.println(num%2 == 0 ? "even":"odd");
        }
    }
}
