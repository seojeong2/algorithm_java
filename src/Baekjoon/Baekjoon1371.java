package Baekjoon;

import java.util.Scanner;

public class Baekjoon1371 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alpha = new int[26];

        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    alpha[str.charAt(i) - 'a']++;
                }
            }
        }
        int max = 0;
        for(int i=0; i<26; i++) {
            max = Math.max(max,alpha[i]);
        }
        for(int i=0; i<26; i++) {
            if(alpha[i] == max) {
                System.out.print((char)(i+'a'));
            }
        }

    }
}
