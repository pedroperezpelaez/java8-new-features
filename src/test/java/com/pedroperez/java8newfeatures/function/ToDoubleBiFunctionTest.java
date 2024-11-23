package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoubleBiFunctionTest {

    @Test
    public void testAddition() {
        // Create a ToDoubleBiFunction that adds two numbers
        ToDoubleBiFunction<Double, Double> addFunction = Double::sum;

        // Test with some test values
        double result = addFunction.applyAsDouble(2.5, 4.0);
        assertEquals(6.5, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        // Create a ToDoubleBiFunction that multiplies two numbers
        ToDoubleBiFunction<Integer, Integer> multiplyFunction = (a, b) -> a * b;

        // Test with some test values
        double result = multiplyFunction.applyAsDouble(2, 3);
        assertEquals(6.0, result, 0.001);
    }
}
