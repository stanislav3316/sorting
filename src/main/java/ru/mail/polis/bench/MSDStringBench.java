package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.Helper;
import ru.mail.polis.sort.MSDString;
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
public class MSDStringBench {
    String[][] data;
    String[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new String[10][100];
        for (int i = 0; i < 10; i++) {
            //Average case
            //data[i] = Helper.genArrString(10000, 100);
            //data[i] = Helper.genArrString(50000, 100);
            //data[i] = Helper.genArrString(100000, 100);

            //the worth case
            //data[i] = Helper.genArrStringTheSameLen(100000, 100);
            //data[i] = Helper.genArrStringTheSameLen(10000, 100);
            //data[i] = Helper.genArrStringTheSameLen(50000, 100);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureMSDStringSort() {
        MSDString.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MSDString.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}