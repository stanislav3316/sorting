package ru.mail.polis.sort;

/**
 * Created by iters on 11/20/16.
 */
public class BinaryQuickSort {
    private static final int INT_BINARY_LENGTH = 31;

    public static int[] sort(int[] ar){
        if (ar == null) {return new int[] {};}
        quickSort(ar, 0, ar.length - 1, INT_BINARY_LENGTH);

        return ar;
    }

    public static int[] quickSort(int[] arr, int l, int r, int bit){
        if (l < r && !(bit < 0)) {
            int index = partition(arr, l, r, bit);

            quickSort(arr, l, index, bit - 1);
            quickSort(arr, index + 1, r, bit - 1);
        }

        return arr;
    }

    static int getBit(int n, int k) {
        return (n >> k) & 1;
    }

    public static int partition(int[] arr, int l, int r, int bit){
        int i = l;
        int j = r;

        while (i <= j) {
            while (i < arr.length && getBit(arr[i], bit) == 0) i++;
            while (j > -1 && getBit(arr[j], bit) == 1) j--;
            if (i <= j) Helper.swap(arr, i++, j--);
        }

        return j;
    }
}