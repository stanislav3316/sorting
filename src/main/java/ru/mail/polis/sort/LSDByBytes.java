package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/26/16.
 */
public class LSDByBytes {
    public static long[] sort(long[] a) {
        final int R = 1 << 8;
        final int MASK = R - 1;
        final int w = 8;

        int n = a.length;
        long[] temp = new long[n];

        for (int d = 0; d < w; d++) {
            long[] count = new long[R + 1];
            for (int i = 0; i < n; i++) {
                int c = (int) ((a[i] >> 8 * d) & MASK);
                count[(c + 1)]++;
            }

            for (int r = 0; r < R; r++)
                count[r + 1] += count[r];

            if (d == w - 1) {
                long shift1 = count[R] - count[R / 2];
                long shift2 = count[R / 2];
                for (int r = 0; r < R / 2; r++)
                    count[r] += shift1;
                for (int r = R / 2; r < R; r++)
                    count[r] -= shift2;
            }

            for (int i = 0; i < n; i++) {
                int c = (int) ((a[i] >> 8 * d) & MASK);
                temp[(int) count[c]++] = a[i];
            }

            for (int i = 0; i < n; i++)
                a[i] = temp[i];
        }
        return a;
    }
}