import java.util.ArrayList;
import java.util.Scanner;

public class Q18_41 {

    public static int n,m;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        parent = new int[n+1];

        // 초기화
        for(int i=1; i<n+1; i++) {
            parent[i] = i;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int x = sc.nextInt();

                if(x==1) {
                    unionParent(i+1,j+1);
                }
            }
        }

        // 여행 계획 입력받기
        ArrayList<Integer> plan = new ArrayList<>();
        for(int i=0; i<m; i++) {
            int x = sc.nextInt();
            plan.add(x);
        }

        boolean result = true;
        for(int i=0; i<m-1; i++) {
            if(findParent(plan.get(i)) != findParent(plan.get(i+1))) {
                result = false; // 여행계획에 해당하는 모든 노드가 같은집합(=같은 부모)를 갖지 않으면 실패
            }
        }
        System.out.println(result ? "YES":"NO");
    }

    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a]= b;
    }
}
