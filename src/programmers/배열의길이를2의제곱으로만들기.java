package programmers;
import java.util.Arrays;

public class 배열의길이를2의제곱으로만들기 {

    public static void main(String[] args) {

        int[] arr = {2,4,5};
        int[] answer = Solution(arr);

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }


    public static int[] Solution(int[] arr) {

        int n = arr.length;
        int target = 1;

        while (target < n) {
            target *= 2;
        }

        int[] answer = new int[target];
        Arrays.fill(answer,0);

        for (int i=0; i<n; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}
