package ru.mail.polis.sort;

import java.util.Objects;

/**
 * Created by iters on 11/18/16.
 */
public class InsertionsSort {
    public static int[] sort(int a[]) {
        if (Objects.isNull(a))
            return new int[0];

        for (int i = 1; i <= a.length - 1; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                Helper.swap(a, j, j - 1);
            }
        }

        return a;
    }
}
