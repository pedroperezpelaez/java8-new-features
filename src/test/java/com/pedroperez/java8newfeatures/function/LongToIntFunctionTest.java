package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.LongToIntFunction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongToIntFunctionTest {

    private LongToIntFunction longToIntFunction;

    @BeforeEach
    public void setup() {
        // For example, convert a long to an int by casting
        longToIntFunction = value -> (int) (value % Integer.MAX_VALUE);
    }

    @Test
    public void testApplyAsInt_withPositiveLong() {
        long input = 123456L;
        int expectedOutput = (int) (input % Integer.MAX_VALUE);

        int result = longToIntFunction.applyAsInt(input);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testApplyAsInt_withNegativeLong() {
        long input = -123456L;
        int expectedOutput = (int) (input % Integer.MAX_VALUE);

        int result = longToIntFunction.applyAsInt(input);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testApplyAsInt_withZero() {
        long input = 0L;
        int expectedOutput = 0;

        int result = longToIntFunction.applyAsInt(input);

        assertEquals(expectedOutput, result);
    }
}

