import java.util.Scanner;

public class Baekjoon11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String num = sc.nextLine();

        int result = 0;
        for(int i=0; i<n; i++) {
            result += num.charAt(i) - '0';
        }
        System.out.println(result);
    }
}
