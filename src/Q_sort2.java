import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q_sort2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Collections.reverseOrder());

        int[] answer = Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        for(int val:answer) {
            System.out.print(val + " ");
        }

    }
}
