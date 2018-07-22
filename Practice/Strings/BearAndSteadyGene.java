package Strings;

import java.util.Scanner;

/**
 * Created by piyus on 28-08-2017 at 19:49.
 * HackerRank. Strings - Medium. Correct after looking at discussions.
 */
public class BearAndSteadyGene {

//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        char[] dna = s.next().toCharArray();
//        int[] gene = new int[4]; //ACTG
//        for (char c : dna)
//            switch (c) {
//                case 'A': gene[0]++; break;
//                case 'C': gene[1]++; break;
//                case 'T': gene[2]++; break;
//                case 'G': gene[3]++; break;
//            }
//        for (int i = 0; i < 4; i++) {
//            gene[i] -= n / 4;
//            if (gene[i] <= 0) gene[i] = 0;
//        }
//
//        // now find the smallest substring containing gene[i] times the ith char
//        System.out.println(smallestSubstr(dna, gene));
//
//    }
//
//    private static int smallestSubstr(char[] dna, int[] gene) {
//        int windowSize = 0;
//        for (int aGene : gene) windowSize += aGene;
//        for (; windowSize < dna.length; windowSize++) {
//            for (int i = 0; i + windowSize < dna.length; i++) {
//                int[] temp = gene.clone();
//                for (int j = i; j < i + windowSize; j++) {
//                    switch (dna[j]) {
//                        case 'A': temp[0]--; break;
//                        case 'C': temp[1]--; break;
//                        case 'T': temp[2]--; break;
//                        case 'G': temp[3]--; break;
//                    }
//                }
//                int c = 0;
//                for (int t : temp) if (t > c) c = t;
//                if (c == 0) return windowSize;
//            }
//        }
//        return dna.length;
//    }

    // See https://www.hackerrank.com/challenges/bear-and-steady-gene/forum/comments/157624
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt() / 4;
        String dna = s.next();
        int[] count = new int[4];
        for (int i = 0; i < dna.length(); i++)
            switch (dna.charAt(i)) {
                case 'A': count[0]++; break;
                case 'C': count[1]++; break;
                case 'T': count[2]++; break;
                case 'G': count[3]++; break;
            }
//        int j = 0;
//        while (!isValid(count, n)) {
//            switch (dna.charAt(j)) {
//                case 'A': count[0]--; break;
//                case 'C': count[1]--; break;
//                case 'T': count[2]--; break;
//                case 'G': count[3]--; break;
//            }
//            j++;
//        }
//        int i = 0;
//        while (true) {
//            switch (dna.charAt(i)) {
//                case 'A': count[0]++; break;
//                case 'C': count[1]++; break;
//                case 'T': count[2]++; break;
//                case 'G': count[3]++; break;
//            }
//            if (!isValid(count, n)) break;
//            i++;
//        }

        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        while (j < dna.length()) {
            if (!isValid(count, n)) {
                switch (dna.charAt(j)) {
                    case 'A': count[0]--; break;
                    case 'C': count[1]--; break;
                    case 'T': count[2]--; break;
                    case 'G': count[3]--; break;
                }
                j++;
            } else {
                if (j - i < minLength) {
                    minLength = j - i;
                }
                switch (dna.charAt(i)) {
                    case 'A': count[0]++; break;
                    case 'C': count[1]++; break;
                    case 'T': count[2]++; break;
                    case 'G': count[3]++; break;
                }
                i++;
            }
        }
        System.out.println(minLength);
    }

    private static boolean isValid(int[] count, int n) {
        for (int aCount : count) {
            if (aCount > n) return false;
        }
        return true;
    }

}
