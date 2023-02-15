package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    private String name;
    private String surname;
    private int age;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        if (hasAge()) happyBirthday();
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        if (age > 0) return true;
        return false;
    }

    public boolean hasAddress() {
        if (address != null) return true;
        else return false;
    }

    public void happyBirthday() {
        this.age++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return name;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        return personBuilder;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Person{");
        stringBuilder.append("name='").append(getName()).append("'");
        stringBuilder.append(", surname='").append(getSurname()).append("'");
        if (hasAge()) {
            stringBuilder.append(", age='").append(getAge().getAsInt()).append("'");
        }

        if (hasAddress()) {
            stringBuilder.append(", address='").append(getAddress()).append("'");
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && address.equals(person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}