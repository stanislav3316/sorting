package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/26/16.
 */
public class BinaryMSD {
    public static void main(String[] args) {
        int[] a = {1,5,6,4,3,2,4,5,6,3,2,1,4,5,3,2};
        a = sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static int[] sort(int[] a) {
        int size = a.length;
        int[] temp = new int[size];
        sort(a, 0, size - 1, 0, temp);
        return a;
    }

    private static void sort(int[] a, int left, int right, int d, int[] temp) {
        int[] count = new int[257];
        int mask = 255;
        int shift = 32 - 8 * d - 8;
        for (int i = left; i <= right; i++) {
            int c = (a[i] >> shift) & mask;
            count[c + 1]++;
        }

        for (int r = 0; r < 256; r++) {
            count[r + 1] += count[r];
        }

        for (int i = left; i <= right; i++) {
            int c = (a[i] >> shift) & mask;
            temp[count[c]++] = a[i];
        }

        for (int i = left; i <= right; i++)
            a[i] = temp[i - left];

        if (d == 4) {
            return;
        }

        if (count[0] > 0) {
            sort(a, left, left + count[0] - 1, d + 1, temp);
        }

        for (int r = 0; r < 256; r++) {
            if (count[r + 1] > count[r]) {
                sort(a, left + count[r], left + count[r + 1] - 1, d + 1, temp);
            }
        }
    }
}