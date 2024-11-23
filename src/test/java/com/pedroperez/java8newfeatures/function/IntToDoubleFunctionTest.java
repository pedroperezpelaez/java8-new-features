package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.IntToDoubleFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntToDoubleFunctionTest {

    private IntToDoubleFunction intToDoubleFunction;

    @BeforeEach
    public void setup() {
        // Sample IntToDoubleFunction that divides the integer by 2.0
        intToDoubleFunction = value -> value / 2.0;
    }

    @Test
    public void testApplyAsDouble() {
        // Test with a positive integer
        double result = intToDoubleFunction.applyAsDouble(10);
        assertEquals(5.0, result, 0.001);

        // Test with zero
        result = intToDoubleFunction.applyAsDouble(0);
        assertEquals(0.0, result, 0.001);

        // Test with a negative integer
        result = intToDoubleFunction.applyAsDouble(-10);
        assertEquals(-5.0, result, 0.001);
    }
}
