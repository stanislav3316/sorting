package ru.mail.polis.sort;

public class BubbleSort {

    public static int[] sort(int a[]) {
        boolean wasSwap = true;
        int j = 0;
        while (wasSwap) {
            wasSwap = false;
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    Helper.swap(a, i, i + 1);
                    wasSwap = true;
                }
            }
            j++;
        }
        return a;
    }
}
