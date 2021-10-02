package com.smalser.test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.smalser.test.proto.AddressBook;
import com.smalser.test.proto.Person;

import java.util.Arrays;
import java.util.List;

public class SimpleMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        AddressBook addressBook = AddressBook.newBuilder()
                .addPerson(newPerson(101, "Sergey S", List.of(
                        newPhone(12345678, Person.PhoneType.MOBILE), newPhone(7654321, Person.PhoneType.WORK))))
                .addPerson(newPerson(102, "Darya S", List.of(newPhone(12345678, Person.PhoneType.MOBILE))))
                .build();

        byte[] serialized = addressBook.toByteArray();
        System.out.println(Arrays.toString(serialized));

        System.out.println("addressBook = " + AddressBook.parseFrom(serialized));
    }

    private static Person.Phone newPhone(int number, Person.PhoneType phoneType) {
        return Person.Phone.newBuilder()
                .setNumber(number)
                .setType(phoneType)
                .build();
    }

    private static Person newPerson(int id, String name, List<Person.Phone> phones) {
        return Person.newBuilder()
                .setId(id)
                .setName(name)
                .addAllPhone(phones)
                .build();
    }
}
