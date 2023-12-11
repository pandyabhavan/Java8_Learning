package com.java8.learning.combinatorPattern;

import java.time.LocalDate;

import static com.java8.learning.combinatorPattern.ICombinatorPattern.*;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("abc", LocalDate.of(2005,1,1),
                "pandyabhavan@gmail.com","1234567890");

        PersonValidator a = validateEmail()
                .and(validatePhone())
                .and(isAdult())
                .apply(p);
        System.out.println(a);

    }
}
