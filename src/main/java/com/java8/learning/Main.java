package com.java8.learning;


import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    enum Gender {
        MALE, FEMALE
    }
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        List<Person> test = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .toList();

        test.forEach(System.out::println);



    }
}
class Person {
    public final String name;
    public final Main.Gender gender;

    Person(String name, Main.Gender gender) {
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

