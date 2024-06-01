package com.smalser.test.jmh;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.UUID;

public class RandomUUIDBenchmark {

    @Benchmark
    public UUID testRandomUUID() {
        return UUID.randomUUID();
    }

}
