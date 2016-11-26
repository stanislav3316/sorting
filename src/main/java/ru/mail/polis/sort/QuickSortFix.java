package ru.mail.polis.sort;

/**
 * Created by iters on 11/19/16.
 */
public class QuickSortFix {
    public static int[] sort(int[] arr) {
        if (arr == null)
            return new int[0];

        sort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void sort(int arr[], int left, int right) {
        if (left >= right) {
            return;
        }

        int m = partition(arr, left, right);
        sort(arr, left, m - 1);
        sort(arr, m + 1, right);
    }

    // выбор первого элемента как опорного
    private static int partition(int[] arr, int left, int right) {
        int index = (left + right + 1) / 2;
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