package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.BinaryMSD;
import ru.mail.polis.sort.Helper;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by iters on 11/26/16.
 */
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class MSDBinaryBench {
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

            //the worth case
            //data[i] = Helper.getReversArr(10000);
            //data[i] = Helper.getReversArr(100000);
            //data[i] = Helper.getReversArr(50000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureBinaryMSDSort() {
        BinaryMSD.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BinaryMSD.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
