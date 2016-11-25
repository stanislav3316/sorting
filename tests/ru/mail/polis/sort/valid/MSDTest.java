package ru.mail.polis.sort.valid;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.mail.polis.sort.MSDString;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * Created by iters on 11/22/16.
 */
@RunWith(value = Parameterized.class)
public class MSDTest {
    private static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };

    private static String[] genArr(int count, int maxLen) {
        Random rnd = new Random();
        String[] a = new String[count];

        for (int i = 0; i < count; i++) {
            StringBuilder str = new StringBuilder();
            int size = rnd.nextInt(maxLen) + 1;
            for (int j = 0; j < size; j++) {
                int pos = rnd.nextInt(letters.length() - 1);
                str.append(letters.substring(pos, 1));
            }
            a[i] = str.toString();
        }
        return a;
    }

    @Parameterized.Parameter
    public String[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<String[]> data() {
        return Arrays.asList(new String[][]{
            genArr(10, 5),
            genArr(5, 5),
            genArr(2, 5)
        });
    }

    private boolean isSorted(String[] a) {
        boolean isSorted = true;
        String[] b = new String[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        Arrays.sort(b);

        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i].equals(b[i]);
        }

        return isSorted;
    }

    @Test
    public void test01_checkMSD_StringSort() throws IOException {
        Assert.assertTrue(isSorted(MSDString.sort(array)));
    }
}
