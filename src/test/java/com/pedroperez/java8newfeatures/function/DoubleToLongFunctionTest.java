package com.pedroperez.java8newfeatures.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.DoubleToLongFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleToLongFunctionTest {

    private DoubleToLongFunction doubleToLongFunction;

    @BeforeEach
    public void setup() {
        // Define a DoubleToLongFunction that truncates the decimal part of the double value.
        doubleToLongFunction = (double value) -> (long) value;
    }

    @Test
    public void whenPositiveDouble_thenTruncatesToLong() {
        double input = 5.7;
        long result = doubleToLongFunction.applyAsLong(input);
        assertEquals(5L, result);
    }

    @Test
    public void whenNegativeDouble_thenTruncatesToLong() {
        double input = -3.8;
        long result = doubleToLongFunction.applyAsLong(input);
        assertEquals(-3L, result);
    }

    @Test
    public void whenDoubleIsZero_thenReturnsZero() {
        double input = 0.0;
        long result = doubleToLongFunction.applyAsLong(input);
        assertEquals(0L, result);
    }

    @Test
    public void whenDoubleIsWholeNumber_thenReturnsSameLong() {
        double input = 4.0;
        long result = doubleToLongFunction.applyAsLong(input);
        assertEquals(4L, result);
    }
}

