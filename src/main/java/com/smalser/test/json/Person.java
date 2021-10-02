package com.smalser.test.json;

import java.util.List;

public class Person {
    public int id;
    public String name;
    public String mail;

    public List<Phone> phone;

    public static class Phone {
        public int number;
        public PhoneType type;
    }

    public enum PhoneType {
        MOBILE,
        HOME,
        WORK
    }
}
