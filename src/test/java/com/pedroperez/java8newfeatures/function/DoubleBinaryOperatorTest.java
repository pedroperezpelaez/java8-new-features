package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleBinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleBinaryOperatorTest {

    // Test DoubleBinaryOperator: Add two doubles and return the sum
    @Test
    public void testDoubleBinaryOperatorAdd() {
        DoubleBinaryOperator add = Double::sum;

        // Apply DoubleBinaryOperator to add two doubles
        double result = add.applyAsDouble(10.5, 20.5);

        assertEquals(31.0, result, 0.001);  // Comparing doubles with a delta of 0.001
    }

    // Test DoubleBinaryOperator: Multiply two doubles and return the product
    @Test
    public void testDoubleBinaryOperatorMultiply() {
        DoubleBinaryOperator multiply = (a, b) -> a * b;

        // Apply DoubleBinaryOperator to multiply two doubles
        double result = multiply.applyAsDouble(5.0, 4.0);

        assertEquals(20.0, result, 0.001);
    }

    // Test DoubleBinaryOperator: Find the maximum of two doubles
    @Test
    public void testDoubleBinaryOperatorMax() {
        DoubleBinaryOperator max = Math::max;

        // Apply DoubleBinaryOperator to find the maximum of two doubles
        double result = max.applyAsDouble(10.5, 20.5);

        assertEquals(20.5, result, 0.001);
    }

    // Test DoubleBinaryOperator: Find the difference between two doubles
    @Test
    public void testDoubleBinaryOperatorDifference() {
        DoubleBinaryOperator difference = (a, b) -> a - b;

        // Apply DoubleBinaryOperator to find the difference between two doubles
        double result = difference.applyAsDouble(20.0, 10.0);

        assertEquals(10.0, result, 0.001);
    }
}
