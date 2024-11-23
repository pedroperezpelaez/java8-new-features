package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiFunctionTest {
    // Test BiFunction: Add two integers and return the sum
    @Test
    public void testBiFunctionAddNumbers() {
        BiFunction<Integer, Integer, Integer> add = Integer::sum;

        // Apply BiFunction to add two numbers
        int result = add.apply(10, 20);

        assertEquals(30, result);
    }

    // Test BiFunction: Concatenate two strings and return the result
    @Test
    public void testBiFunctionConcatenateStrings() {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;

        // Apply BiFunction to concatenate two strings
        String result = concatenate.apply("Hello", "World");

        assertEquals("Hello World", result);
    }

    // Test BiFunction: Compare two integers and return the larger one
    @Test
    public void testBiFunctionCompareNumbers() {
        BiFunction<Integer, Integer, Integer> max = (a, b) -> a > b ? a : b;

        // Apply BiFunction to find the maximum of two numbers
        int result = max.apply(10, 20);

        assertEquals(20, result);
    }

    // Test BiFunction: Compute the product of two numbers and return the result
    @Test
    public void testBiFunctionMultiplyNumbers() {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        // Apply BiFunction to multiply two numbers
        int result = multiply.apply(5, 4);

        assertEquals(20, result);
    }
}
