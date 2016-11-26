package ru.mail.polis.bench;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.mail.polis.sort.LSDByBytes;
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
public class LSDLongBench {
    long[][] data;
    long[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new long[10][100];
        for (int i = 0; i < 10; i++) {
            //average case
            //data[i] = Helper.genLong(50000, 5000);
            //data[i] = Helper.genLong(10000, 1000);
            //data[i] = Helper.genLong(100000, 10000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureLSDByBytesSort() {
        LSDByBytes.sort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDByBytes.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
