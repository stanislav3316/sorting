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
public class MSDStringTest {
    private static String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String[] genArr(int count, int maxLen) {
        Random rnd = new Random();
        String[] a = new String[count];

        for (int i = 0; i < count; i++) {
            StringBuilder str = new StringBuilder();
            int size = rnd.nextInt(maxLen) + 1;
            for (int j = 0; j < size; j++) {
                int pos = rnd.nextInt(letters.length());
                str.append(letters.charAt(pos));
            }
            a[i] = str.toString();
        }
        return a;
    }

    @Parameterized.Parameter
    public String[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Object[][] data() {
        return new Object[][] {
                genArr(10, 5),
                genArr(15, 2),
                genArr(18, 14)
        };
    }

    private boolean isSorted(String[] a) {
        return true;
    }

    @Test
    public void test01_checkMSD_StringSort() throws IOException {
        Assert.assertTrue(isSorted(MSDString.sort(array)));
    }
}
