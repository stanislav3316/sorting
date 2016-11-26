package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.BinaryMSD;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.LSDByBytes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by iters on 11/22/16.
 */
@RunWith(value = Parameterized.class)
public class LSDByBytesTest {
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

    private static long[] allZeros(int len) {
        long[] a = new long[len];
        Arrays.fill(a, 0);
        return a;
    }

    @Parameterized.Parameter
    public long[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<long[]> data() {
        return Arrays.asList(new long[][]{
                {Long.MAX_VALUE, Long.MAX_VALUE},
                Helper.genSortedArrWithDuplicatesLong(1000, 100),
                Helper.genSortedArrWithDuplicatesLong(5000, 500),
                {Long.MAX_VALUE, 0, 0, Long.MAX_VALUE},
                Helper.genLong(1),
                Helper.genLong(10),
                Helper.genLong(100),
                Helper.genLong(1000),
                Helper.genLong(10000),
                allZeros(10),
                allZeros(100),
                allZeros(100),
        });
    }

    private boolean isSorted(long[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
        }
        return isSorted;
    }

    @Test
    public void test01_BinarySort() throws IOException {
        Assert.assertTrue(isSorted(LSDByBytes.sort(array)));
    }
}