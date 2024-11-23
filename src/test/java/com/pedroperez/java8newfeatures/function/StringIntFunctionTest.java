package com.pedroperez.java8newfeatures.function;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.IntFunction;

public class StringIntFunctionTest {

    private IntFunction<String> toStringFunction;

    @BeforeEach
    public void setUp() {
        toStringFunction = Objects::toString;
    }

    @Test
    public void testIntFunction_forPositiveInt() {
        int input = 123;
        String expected = "123";

        String result = toStringFunction.apply(input);

        assertEquals(expected, result, "The conversion of input to string did not match the expected value.");
    }

    @Test
    public void testIntFunction_forZero() {
        int input = 0;
        String expected = "0";

        String result = toStringFunction.apply(input);

        assertEquals(expected, result, "The conversion of input zero to string did not match the expected value.");
    }

    @Test
    public void testIntFunction_forNegativeInt() {
        int input = -456;
        String expected = "-456";

        String result = toStringFunction.apply(input);

        assertEquals(expected, result, "The conversion of a negative input to string did not match the expected value.");
    }
}

