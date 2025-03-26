package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1202 {
    // 보석 도둑 문제

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        List<Jewerly> jewerlyList = new ArrayList<>();

        // 입력부
        for (int i=0; i<n; i++) {
            String[] jewelInput = br.readLine().split(" ");
            jewerlyList.add(new Jewerly(Integer.parseInt(jewelInput[0]),Integer.parseInt(jewelInput[1])));
        }

        int[] bags = new int[k];
        for (int i=0; i<k; i++) {
            String bag = br.readLine();
            bags[i] = Integer.parseInt(bag);
        }

        // jewerlList 정렬
        Collections.sort(jewerlyList);
        Arrays.sort(bags); // 가방 오름차순 정렬

        long answer = 0;
        // 가방 무게 오름차순으로 비교하면서 jewerlyList에 넣을수 있는지 비교
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 보석 가격 높은것부터 정렬
         // 가방 체크위한 인덱스
        int j= 0;
        for (int i=0; i<k; i++) {
            while(j < n && jewerlyList.get(j).weight <= bags[i]) {
                pq.add(jewerlyList.get(j).price);
                j++;
            }
            // 넣을 수 있는 보석부터 가격이 가장 큰거 넣기
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);

    }
    static class Jewerly implements Comparable<Jewerly>{
        public int weight;
        public int price;


        public Jewerly(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }


        @Override
        public int compareTo(Jewerly o) { //o는 현재 비교대
            if (this.weight == o.weight) {
                return Integer.compare(o.price, this.price); // price 내림차순
            }
            return Integer.compare(this.weight, o.weight); // weight 오름차순
        }
    }
}
