package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryOperatorTest {
    // Test BinaryOperator: Add two integers and return the sum
    @Test
    public void testBinaryOperatorAdd() {
        BinaryOperator<Integer> add = Integer::sum;

        // Apply BinaryOperator to add two numbers
        int result = add.apply(10, 20);

        assertEquals(30, result);
    }

    // Test BinaryOperator: Find the maximum of two integers
    @Test
    public void testBinaryOperatorMax() {
        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;

        // Apply BinaryOperator to find the maximum of two numbers
        int result = max.apply(10, 20);

        assertEquals(20, result);
    }

    // Test BinaryOperator: Multiply two numbers and return the product
    @Test
    public void testBinaryOperatorMultiply() {
        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        // Apply BinaryOperator to multiply two numbers
        int result = multiply.apply(5, 4);

        assertEquals(20, result);
    }

    // Test BinaryOperator: Concatenate two strings
    @Test
    public void testBinaryOperatorConcatenateStrings() {
        BinaryOperator<String> concatenate = (s1, s2) -> s1 + " " + s2;

        // Apply BinaryOperator to concatenate two strings
        String result = concatenate.apply("Hello", "World");

        assertEquals("Hello World", result);
    }
}
