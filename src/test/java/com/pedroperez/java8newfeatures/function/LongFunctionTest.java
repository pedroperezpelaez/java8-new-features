package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.LongFunction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongFunctionTest {

    private LongFunction<String> longToStringFunction;

    @BeforeEach
    public void setUp() {
        longToStringFunction = value -> "Value is " + value; // Converts long to String
    }

    @Test
    public void whenApply_thenCorrectStringReturned() {
        long input = 42L;
        String expectedResult = "Value is 42";

        String result = longToStringFunction.apply(input);

        assertEquals(expectedResult, result);
    }

    @Test
    public void whenNegativeValue_thenCorrectStringReturned() {
        long input = -19L;
        String expectedResult = "Value is -19";

        String result = longToStringFunction.apply(input);

        assertEquals(expectedResult, result);
    }

    @Test
    public void whenZeroValue_thenCorrectStringReturned() {
        long input = 0L;
        String expectedResult = "Value is 0";

        String result = longToStringFunction.apply(input);

        assertEquals(expectedResult, result);
    }
}
