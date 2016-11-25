package ru.mail.polis.sort;

/**
 * Created by iters on 11/18/16.
 */
public class ShellSort {
    public static int[] sort(int[] a) {
        if (a == null) {
            return new int[0];
        }

        int n = a.length;
        int h = 1;
        while (h < n / 3) {h = 3 * h + 1;}
        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
                    Helper.swap(a, j, j - h);
                }
            }
            h /= 3;
        }

        return a;
    }
}
