package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorTest {

    private IntUnaryOperator incrementOperator;
    private IntUnaryOperator doubleOperator;

    @BeforeEach
    public void setup() {
        incrementOperator = x -> x + 1;
        doubleOperator = x -> x * 2;
    }

    @Test
    public void testIncrementOperatorWithPositiveNumber() {
        int result = incrementOperator.applyAsInt(5);
        assertEquals(6, result);
    }

    @Test
    public void testIncrementOperatorWithZero() {
        int result = incrementOperator.applyAsInt(0);
        assertEquals(1, result);
    }

    @Test
    public void testIncrementOperatorWithNegativeNumber() {
        int result = incrementOperator.applyAsInt(-5);
        assertEquals(-4, result);
    }

    @Test
    public void testDoubleOperatorWithPositiveNumber() {
        int result = doubleOperator.applyAsInt(5);
        assertEquals(10, result);
    }

    @Test
    public void testDoubleOperatorWithZero() {
        int result = doubleOperator.applyAsInt(0);
        assertEquals(0, result);
    }

    @Test
    public void testDoubleOperatorWithNegativeNumber() {
        int result = doubleOperator.applyAsInt(-5);
        assertEquals(-10, result);
    }
}

