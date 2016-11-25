package ru.mail.polis.sort;

import java.util.Random;

/**
 * Created by iters on 11/19/16.
 */
public class QuickSortRndPart {
    public static int[] sort(int[] a) {
        if (a == null)
            return new int[0];

        sort(a, 0, a.length - 1);
        return a;
    }

    private static void sort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        Random rnd = new Random();
        int index = rnd.nextInt(right - left + 1) + left;
        Helper.swap(arr, left, index);

        int x = arr[left];
        int j = left;
        int k = left;

        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < x) {
                j++;
                Helper.swap(arr, i , j);
            } else if (arr[i] == x) {
                k++;
                j++;
                Helper.swap(arr, i, j);
                Helper.swap(arr, k, j);
            }
        }

        int oldJ = j;
        for (int i = left; i <= k; i++) {
            Helper.swap(arr, i, j--);
        }

        sort(arr, left, j);
        sort(arr, oldJ + 1, right);
    }
}