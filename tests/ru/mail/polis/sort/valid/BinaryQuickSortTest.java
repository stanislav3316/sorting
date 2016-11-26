package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.BinaryQuickSort;
import ru.mail.polis.sort.Helper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by iters on 11/22/16.
 */
@RunWith(value = Parameterized.class)
public class BinaryQuickSortTest {
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private static int[] genNegative(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            if (Math.random() > 0.5) {
                arr[i] = (-1) * arr[i];
            }
        }
        return arr;
    }

    private static int[] allZeros(int len) {
        int[] a = new int[len];
        Arrays.fill(a, 0);
        return a;
    }

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                Helper.genSortedArrWithDuplicates(1000, 100),
                Helper.genSortedArrWithDuplicates(5000, 500),
                {Integer.MAX_VALUE, 0, 0, Integer.MAX_VALUE},
                Helper.gen(1),
                Helper.gen(10),
                Helper.gen(100),
                Helper.gen(1000),
                Helper.gen(10000),
                allZeros(10),
                allZeros(100),
                allZeros(100),
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_BinarySort() throws IOException {
        Assert.assertTrue(isSorted(BinaryQuickSort.sort(array)));
    }
}
