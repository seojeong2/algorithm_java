import java.util.Scanner;

public class UnionFind {

    // 노드의 개수(v), 간선의 개수(E)
    public static int v,e;
    // 부모 테이블
    public static int[] parent = new int[100001];

    // 특정 원소가 속한 집합 찾기
    public static int findParent(int x){
        if(x == parent[x]) return x; // 부모인지
        return findParent(parent[x]); // 재귀적으로 부모 찾기
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a); // 각자의 부모 찾기
        b = findParent(b);

        if(a<b) parent[b] = a;
        else parent[a] = b; // 노드 번호중에 더 작은 노드 번호를 큰번호의 부모로 세팅
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        // 부모테이블 초기화 -> 자기 자신을 부모로
        for(int i=1; i<=v; i++) {
            parent[i] = i;
        }
        // Union 연산을 각각 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }



        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

}
