package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleToIntFunctionTest {

    private DoubleToIntFunction doubleToIntFunction;

    @BeforeEach
    public void setup() {
        // Example function that returns the floor of a double value
        doubleToIntFunction = (double value) -> (int) Math.floor(value);
    }

    @Test
    public void testDoubleToIntFunctionWithPositiveValue() {
        double input = 5.7;
        int expectedOutput = 5;
        int actualOutput = doubleToIntFunction.applyAsInt(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDoubleToIntFunctionWithNegativeValue() {
        double input = -3.2;
        int expectedOutput = -4;
        int actualOutput = doubleToIntFunction.applyAsInt(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDoubleToIntFunctionWithExactInteger() {
        double input = 10.0;
        int expectedOutput = 10;
        int actualOutput = doubleToIntFunction.applyAsInt(input);
        assertEquals(expectedOutput, actualOutput);
    }
}



