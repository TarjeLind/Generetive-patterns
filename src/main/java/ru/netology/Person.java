package ru.netology;

import java.util.NoSuchElementException;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String lastname;
    private int age;
    private String city;

    public Person(String name, String lastname, int age, String city) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    public boolean hasAge() {
        return this.age >= 0;
    }

    public boolean hasAddress() {
        return this.city != null;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public OptionalInt getAge() {
        try {
            return OptionalInt.of(age);
        } catch (NoSuchElementException e) {
            System.out.println("Введен недопустимый возраст");
            return OptionalInt.empty();
        }
    }

    public String getCity() {
        return city;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setLastname(getLastname()).setAddress(getCity());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append(" ");
        str.append(lastname);
        if (hasAge()) {
            str.append(", возраст: ");
            str.append(age);
            str.append(" лет");
        }
        if (hasAddress()) {
            str.append(", адрес: ");
            str.append(city);
        }
        return str.toString();
    }
}