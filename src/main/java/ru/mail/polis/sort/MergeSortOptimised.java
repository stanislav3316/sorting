package ru.mail.polis.sort;

/**
 * Created by iters on 11/19/16.
 */
public class MergeSortOptimised {
    public static int[] sort(int[] x) {
        if (x == null)
            return new int[0];

        sort(x, 0, x.length - 1);
        return x;
    }

    private static void sort(int[] x, int left, int right) {
        int mid, l, r;
        int tmp;

        if (left >= right) {
            return;
        }

        mid = (left + right) / 2;

        sort(x, left, mid);
        sort(x, mid + 1, right);

        l = left;
        r = mid + 1;

        if (x[mid] <= x[r]) {
            return;
        }

        while (l <= mid && r <= right) {
            if (x[l] <= x[r]) {
                l++;
            } else {
                tmp = x[r];
                System.arraycopy(x, l, x, l+1, r-l);
                x[l] = tmp;
                l++;  mid++;  r++;
            }
        }
    }
}