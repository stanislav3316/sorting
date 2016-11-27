package ru.mail.polis.sort.valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.Helper;

@RunWith(value = Parameterized.class)
public class Tester {

    private static final Random r = ThreadLocalRandom.current();

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private static int[] gen(int n) {
        int[] a = new int[n];
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
            {0},
            {0, 0, 0, 0},
            {4, 3, 2, 1},
            {0, 1, 1, 0},
            {1},
            {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
            gen(1),
            gen(10),
            gen(100),
            gen(1000),
            gen(10000),
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
    public void test01_checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.sort(array)));
    }

}
