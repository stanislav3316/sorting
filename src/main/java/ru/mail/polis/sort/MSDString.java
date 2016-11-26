package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/22/16.
 */
public class MSDString {
    private static int R = 256;
    private static final int minLen = 15;
    private static String[] arr;

    public static void main(String[] args) {
        String[] arr = {"byQdZ", "Tx", "E", "Emho", "aVk", "Oibuf", "zY", "KAQJ", "QxG", "uYywe"};
        sort(arr);
        System.out.println(Arrays.toString(arr));
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
        arr = new String[N];
        sort(a, 0, N - 1, 0);
        return a;
    }

    private static void InsertionSort(String[] a, int left, int right, int d) {
        for (int i = left; i <= right; i++)
            for (int j = i; j > left && less(a[j], a[j - 1], d); j--)
                Helper.swap(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void sort(String[] a, int left, int right, int d) {
        if (right <= left + minLen) {
            InsertionSort(a, left, right, d); return;
        }

        int[] count = new int[R + 2];

        for (int i = left; i <= right; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        for (int i = left; i <= right; i++) {
            arr[count[charAt(a[i], d) + 1]++] = a[i];
        }

        for (int i = left; i <= right; i++) {
            a[i] = arr[i - left];
        }

        for (int r = 0; r < R; r++) {
            sort(a, left + count[r], left + count[r+1] - 1, d + 1);
        }
    }
}
