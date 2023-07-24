import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q_sort4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n];
        Integer[] B = new Integer[n];

        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i=0; i<k; i++) {
            if(A[i] < B[i]) {
                A[i] = B[i];
            } else{
                break;
            }
        }
        int answer = 0;
        for(int val:A) {
            answer += val;
        }
        System.out.println(answer);
    }
}
