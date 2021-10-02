package com.smalser.test.jmh;

import com.smalser.test.json.AddressBook;
import org.openjdk.jmh.annotations.Benchmark;

public class JacksonBenchmark {

    @Benchmark
    public byte[] testJacksonSerialization(JacksonSetup jacksonSetup) {
        return JacksonUtils.serialize(jacksonSetup.addressBook);
    }

    @Benchmark
    public AddressBook testJacksonDeserialization(JacksonSetup jacksonSetup) {
        return JacksonUtils.deserialize(jacksonSetup.addressBookBytes);
    }
}
