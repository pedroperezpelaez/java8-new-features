package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.LongToDoubleFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongToDoubleFunctionTest {

    private LongToDoubleFunction longToDoubleFunctionSquareRoot;
    private LongToDoubleFunction longToDoubleFunctionHalf;

    @BeforeEach
    public void setup() {
        // Define a function that computes the square root of the input long
        longToDoubleFunctionSquareRoot = (long value) -> Math.sqrt((double) value);

        // Define a function that computes half of the input long as double
        longToDoubleFunctionHalf = (long value) -> value / 2.0;
    }

    @Test
    public void testSquareRootFunction() {
        // Test the square root function
        assertEquals(3.0, longToDoubleFunctionSquareRoot.applyAsDouble(9L), 0.001);
        assertEquals(4.0, longToDoubleFunctionSquareRoot.applyAsDouble(16L), 0.001);
        assertEquals(0.0, longToDoubleFunctionSquareRoot.applyAsDouble(0L), 0.001);
    }

    @Test
    public void testHalfFunction() {
        // Test the half function
        assertEquals(2.5, longToDoubleFunctionHalf.applyAsDouble(5L), 0.001);
        assertEquals(7.5, longToDoubleFunctionHalf.applyAsDouble(15L), 0.001);
        assertEquals(0.0, longToDoubleFunctionHalf.applyAsDouble(0L), 0.001);
    }
}

