package com.java8.learning.streams;

import com.java8.learning.Main;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.java8.learning.streams.StreamTest.Gender.*;

public class StreamTest {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );



        people.stream().map(person ->  person.gender).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("........");

        System.out.println(people.stream().anyMatch(person -> NONE.equals(person.gender)));

        Object o  = Optional.ofNullable("value").orElseGet(() -> "default");
        System.out.println(o);

    }

     enum Gender {
        MALE, FEMALE, NONE
    }
    static class Person {
        public final String name;
        public final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
