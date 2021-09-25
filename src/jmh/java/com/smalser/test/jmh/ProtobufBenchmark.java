package com.smalser.test.jmh;

import com.google.protobuf.InvalidProtocolBufferException;
import com.smalser.test.proto.AddressBook;
import org.openjdk.jmh.annotations.Benchmark;

public class ProtobufBenchmark {

    @Benchmark
    public byte[] testProtoSerialization(ProtobufSetup protobufSetup) {
        return protobufSetup.addressBook.toByteArray();
    }

    @Benchmark
    public AddressBook testProtoDeserialization(ProtobufSetup protobufSetup) throws InvalidProtocolBufferException {
        return AddressBook.parseFrom(protobufSetup.addressBookBytes);
    }
}
