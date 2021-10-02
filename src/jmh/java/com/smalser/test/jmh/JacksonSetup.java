package com.smalser.test.jmh;

import com.smalser.test.json.AddressBook;
import com.smalser.test.json.Person;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.List;

@State(Scope.Benchmark)
public class JacksonSetup {

    public AddressBook addressBook = buildAddressBook();

    private AddressBook buildAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.person = List.of(
                newPerson(101, "Sergey S", List.of(newPhone(12345678, Person.PhoneType.MOBILE), newPhone(7654321, Person.PhoneType.WORK))),
                newPerson(102, "Darya S", List.of(newPhone(12345678, Person.PhoneType.MOBILE))),
                newPerson(103, "Someone Else", List.of(newPhone(44444444, Person.PhoneType.MOBILE), newPhone(5555555, Person.PhoneType.WORK)))
        );
        return addressBook;
    }

    public byte[] addressBookBytes = JacksonUtils.serialize(addressBook);

    private Person.Phone newPhone(int number, Person.PhoneType phoneType) {
        Person.Phone phone = new Person.Phone();
        phone.number = number;
        phone.type = phoneType;
        return phone;
    }

    private Person newPerson(int id, String name, List<Person.Phone> phones) {
        Person person = new Person();
        person.id = id;
        person.name = name;
        person.phone = phones;
        return person;
    }
}
