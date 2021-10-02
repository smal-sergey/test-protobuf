package com.smalser.test.jmh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smalser.test.json.AddressBook;

import java.io.IOException;

public class JacksonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static byte[] serialize(AddressBook addressBook) {
        try {
            return mapper.writeValueAsBytes(addressBook);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static AddressBook deserialize(byte[] bytes) {
        try {
            return mapper.readValue(bytes, AddressBook.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
