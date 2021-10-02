package com.smalser.test.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class JmhRunner {
    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(ProtobufBenchmark.class.getSimpleName())
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();

        double jacksonSize = new JacksonSetup().addressBookBytes.length;
        double protoSize = new ProtobufSetup().addressBookBytes.length;
        System.out.println("jacksonSize = " + jacksonSize);
        System.out.println("protoSize = " + protoSize);
        System.out.println(jacksonSize / protoSize);
    }

}
