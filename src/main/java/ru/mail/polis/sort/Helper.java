package ru.mail.polis.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {
    private static final Random r = ThreadLocalRandom.current();

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static void swap(String[] a, int i, int j) {
        String x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    public static int[] getReversArr(int size) {
        int[] a = genSortedArr(size);
        for (int i = 0; i < a.length / 2; i++) {
            Helper.swap(a, i, a.length - i - 1);
        }
        return a;
    }

    public static int[] gen(int len, int rng) {
        int[] a = new int[len];
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = rnd.nextInt(rng);
        }
        return a;
    }

    public static int[] genSortedArr(int size) {
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        return a;
    }

    public static int[] getArrBadForQuickFix(int size) {
        int N = size;
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;

        if (N == 2) {
            arr[0] = 2;
            arr[1] = 1;
            return arr;
        } else if(N == 1) {
            arr[0] = 1;
            return arr;
        }

        int right = 2;
        for (int i = 4; i <= N; i++) {
            int mid = (right + 1) / 2;
            arr[right + 1] = i;
            swap(arr, mid, right + 1);
            right++;
        }
        return arr;
    }

    public static int[] genSortedArrWithDuplicates(int size, int rng) {
        int[] a = gen(size, rng);
        Arrays.sort(a);
        return a;
    }
}
