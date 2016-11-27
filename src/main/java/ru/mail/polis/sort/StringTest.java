package ru.mail.polis.sort;

import java.util.Arrays;

/**
 * Created by iters on 11/27/16.
 */
public class StringTest {
    public static void main(String[] args) {
        boolean result = testMe(genData(10, 15));
        if (result) {
            System.out.println("OK");
        } else {
            System.out.println("algoritm isn't correct");
        }
    }

    public static String[][] genData(int count, int maxLen) {
        String[][] arr = new String[count][];
        for (int i = 0; i < count; i++) {
            arr[i] = Helper.genArrString(count, maxLen);
        }
        return arr;
    }

    public static boolean testMe(String[][] arr) {
        boolean isPassed = true;
        String[][] tester = Arrays.copyOf(arr, arr.length);

        outer:
        for (int i = 0; i < tester.length; i++) {
            Arrays.sort(tester[i]);
            arr[i] = MSDString.sort(arr[i]);
            for (int j = 0; j < arr[i].length; j++) {
                if (!(arr[i][j].equals(tester[i][j]))) {
                    isPassed = false;
                    break outer;
                }
            }
        }
        return isPassed;
    }
}
