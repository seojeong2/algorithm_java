package Baekjoon;

import java.util.Scanner;

public class Baekjoon11725 {

    public static int n;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        parent = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i; // 초기화
        }

        for(int i=0; i<n-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            unionParent(a,b);
        }

        for(int val:parent) {
            System.out.print(val+" ");
        }

    }

    public static int findParent(int x) {
        if(x == parent[x]) return x;
        return findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b); // 각자의 부모 찾기

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

}
