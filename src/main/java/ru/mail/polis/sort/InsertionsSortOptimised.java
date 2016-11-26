package ru.mail.polis.sort;

import java.util.Objects;

/**
 * Created by iters on 11/18/16.
 */
public class InsertionsSortOptimised {
    public static int[] sort(int[] a) {
        if (Objects.isNull(a))
            return new int[0];

        for (int i = 1; i <= a.length - 1; i++) {
            int pos = binSearchLeft(a, a[i], i);
            int temp = a[i];
            System.arraycopy(a, pos, a, pos + 1, i - pos);
            a[pos] = temp;
        }

        return a;
    }

    public static int binSearchLeft(int[] arr, int key, int right) {
        int left = -1;
        int mid;

        while (left < right - 1) {
            mid = (left + right) / 2;

            if (arr[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
}