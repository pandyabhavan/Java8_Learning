package com.java8.learning.functionalInterface;

import java.util.function.*;

public class _Function {
    public static void main(String[] args) {
        System.out.println(isStringLengthAboveSix.apply(7));
        System.out.println(sizeOfString.apply("HELLO  "));

        //Function chaining
        System.out.println(sizeOfString.andThen(isStringLengthAboveSix).apply("abdcdef"));
        System.out.println(multiply.apply(3,5));
        System.out.println(multiplyInt.applyAsInt(3,5));
        printString.accept("abc");
        System.out.println(isLengthAboveSix.test("abcdefsd"));
    }

    static Consumer<String> printString = System.out::println;
    static  Function<Integer, Boolean> isStringLengthAboveSix = s -> s > 6;

    static Predicate<String> isLengthAboveSix = s -> s.length() > 6;
    static  Function<String, Integer> sizeOfString = String::length;

    static BiFunction<Integer, Integer,Integer> multiply = (a, b) -> a*b;
    static ToIntBiFunction<Integer, Integer> multiplyInt = (a, b) -> a*b;
}
