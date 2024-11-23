package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTest {

    private Function<String, Integer> stringLengthFunction;

    @BeforeEach
    public void setUp() {
        // Initialize the function to test
        stringLengthFunction = String::length;
    }

    @Test
    public void givenNonNullString_whenApply_thenReturnsCorrectLength() {
        String testString = "hello";
        Integer expectedLength = 5;

        Integer result = stringLengthFunction.apply(testString);

        assertEquals(expectedLength, result);
    }

    @Test
    public void givenEmptyString_whenApply_thenReturnsZero() {
        String testString = "";
        Integer expectedLength = 0;

        Integer result = stringLengthFunction.apply(testString);

        assertEquals(expectedLength, result);
    }

    @Test
    public void givenNullString_whenApply_thenThrowsException() {
        // Use a lambda to assert that a NullPointerException is thrown
        assertThrows(NullPointerException.class, () -> stringLengthFunction.apply(null));
    }
}

