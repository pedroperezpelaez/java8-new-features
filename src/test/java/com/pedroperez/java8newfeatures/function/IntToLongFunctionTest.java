package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.IntToLongFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntToLongFunctionTest {

    private IntToLongFunction intToLongFunction;

    @BeforeEach
    public void setup() {
        // Example function: Multiply by 1000 (e.g., convert seconds to milliseconds)
        intToLongFunction = seconds -> seconds * 1000L;
    }

    @Test
    public void whenApplied_thenCorrectLongResult() {
        int input = 2;
        long expectedOutput = 2000L;
        long result = intToLongFunction.applyAsLong(input);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void whenZeroInput_thenZeroOutput() {
        int input = 0;
        long expectedOutput = 0L;
        long result = intToLongFunction.applyAsLong(input);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void whenNegativeInput_thenCorrectLongResult() {
        int input = -3;
        long expectedOutput = -3000L;
        long result = intToLongFunction.applyAsLong(input);

        assertEquals(expectedOutput, result);
    }
}
