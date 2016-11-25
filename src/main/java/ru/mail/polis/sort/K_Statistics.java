package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by iters on 11/19/16.
 */
public class K_Statistics {
    public static int getK(int[] a, int k) {
        return halfSort(a, k);
    }

    private static int halfSort(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            if (left >= right)
                return arr[left];

            int mid = partition(arr, left, right);

            if (mid == k) {
                return arr[mid];
            } else if (mid < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static int partition(int[] arr, int left, int right) {
        Random rnd = new Random();
        int index = rnd.nextInt(right - left) + left;
        Helper.swap(arr, left, index);

        int x = arr[left];
        int j = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= x) {
                j++;
                Helper.swap(arr, i , j);
            }
        }
        Helper.swap(arr, left, j);

        return j;
    }
}