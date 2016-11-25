package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/22/16.
 */
public class MSDString {
    private static int R = 256;
    private static final int M = 15;
    private static String[] aux;

    public static void main(String[] args) {
        String[] a = {
                "a",
                "bc",
                "bcd",
                "ab"
        };

        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        }

        return -1;
    }

    public static String[] sort(String[] a)
    {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
        return a;
    }

    public static void sortIns(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                Helper.swap(a, j, j-1);
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            sortIns(a, lo, hi, d); return;
        }

        int[] count = new int[R+2];

        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R+1; r++) {
            count[r + 1] += count[r];
        }

        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1);
        }
    }
}
