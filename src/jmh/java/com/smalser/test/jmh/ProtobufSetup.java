package com.smalser.test.jmh;

import com.smalser.test.proto.AddressBook;
import com.smalser.test.proto.Person;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.List;

@State(Scope.Benchmark)
public class ProtobufSetup {
    public AddressBook addressBook = AddressBook.newBuilder()
            .addPerson(newPerson(101, "Sergey S", List.of(newPhone(12345678, Person.PhoneType.MOBILE), newPhone(7654321, Person.PhoneType.WORK))))
            .addPerson(newPerson(102, "Darya S", List.of(newPhone(12345678, Person.PhoneType.MOBILE))))
            .addPerson(newPerson(103, "Someone Else", List.of(newPhone(44444444, Person.PhoneType.MOBILE), newPhone(5555555, Person.PhoneType.WORK))))
            .build();

    public byte[] addressBookBytes = addressBook.toByteArray();

    private Person.Phone newPhone(int number, Person.PhoneType phoneType) {
        return Person.Phone.newBuilder()
                .setNumber(number)
                .setType(phoneType)
                .build();
    }

    private Person newPerson(int id, String name, List<Person.Phone> phones) {
        return Person.newBuilder()
                .setId(id)
                .setName(name)
                .addAllPhone(phones)
                .build();
    }
}
