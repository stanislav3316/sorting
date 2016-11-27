package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/18/16.
 */
public class MergeSort {
    public static int[] sort(int[] arr) {
        if (arr == null)
            return new int[0];

        if (arr.length == 1) {
            return arr;
        }

        int average = arr.length / 2;
        int[] leftArr = Arrays.copyOf(arr, average);
        int[] rightArr = Arrays.copyOfRange(arr, average, arr.length);

        leftArr = sort(leftArr);
        rightArr = sort(rightArr);

        // merge
        int k = 0, j = 0;
        while (k < leftArr.length && j < rightArr.length) {
            if (leftArr[k] <= rightArr[j]) {
                arr[k + j] = leftArr[k++];
            } else {
                arr[k + j] = rightArr[j++];
            }
        }

        while (k < leftArr.length) {
            arr[k + j] = leftArr[k++];
        }

        while (j < rightArr.length) {
            arr[k + j] = rightArr[j++];
        }

        return arr;
    }
}
