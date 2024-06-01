package com.smalser.test.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
@Measurement(iterations = 5, timeUnit = TimeUnit.MILLISECONDS, time = 5000)
public class JmhRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RandomUUIDBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();

//        double jacksonSize = new JacksonSetup().addressBookBytes.length;
//        double protoSize = new ProtobufSetup().addressBookBytes.length;
//        System.out.println("jacksonSize = " + jacksonSize);
//        System.out.println("protoSize = " + protoSize);
//        System.out.println(jacksonSize / protoSize);
    }

}
