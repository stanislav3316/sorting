package ru.mail.polis.sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,3,4,5,4,3,1,2,3,4,2,1,1,2};
        inPlaceSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void inPlaceSort (int[] x) {
        inPlaceSort (x, 0, x.length - 1);
    }

    private static void inPlaceSort (int[] x, int left, int right) {
        int mid, l, r;
        int tmp;

        if (left >= right) {
            return;
        }

        mid = (left + right) / 2;

        inPlaceSort (x, left, mid);
        inPlaceSort (x, mid + 1, right);

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