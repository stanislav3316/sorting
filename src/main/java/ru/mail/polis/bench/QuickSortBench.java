package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
/**
 * Created by iters on 11/21/16.
 */
public class QuickSortBench {
    int[][] data;
    int[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][100];
        for (int i = 0; i < 10; i++) {
            //Average case
            //data[i] = Helper.gen(50000, 5000);
            //data[i] = Helper.gen(10000, 1000);
            //data[i] = Helper.gen(100000, 10000);

            //The best case
            //data[i] = Helper.genSortedArrWithDuplicates(10000, 1000);
            //data[i] = Helper.genSortedArrWithDuplicates(50000, 5000);
            //data[i] = Helper.genSortedArrWithDuplicates(100000, 10000);

            //The worth case
            //data[i] = Helper.getArrBadForQuickFix(10000);
            data[i] = Helper.getArrBadForQuickFix(50000);
            //data[i] = Helper.getArrBadForQuickFix(100000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureQuickSort() {
        QuickSortFix.sort(curr);
    }

    @Benchmark
    public void measureQuickOptimisedSort() {
        QuickSortRndPart.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
