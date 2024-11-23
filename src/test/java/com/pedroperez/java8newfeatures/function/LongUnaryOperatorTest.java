package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.LongUnaryOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongUnaryOperatorTest {

    private LongUnaryOperator doubleValue;
    private LongUnaryOperator squareValue;

    @BeforeEach
    public void setup() {
        doubleValue = x -> x * 2;  // Operation to double the value
        squareValue = x -> x * x;  // Operation to square the value
    }

    @Test
    public void whenDoubleValue_thenCorrect() {
        long input = 5L;
        long expected = 10L;
        long result = doubleValue.applyAsLong(input);
        assertEquals(expected, result);
    }

    @Test
    public void whenSquareValue_thenCorrect() {
        long input = 4L;
        long expected = 16L;
        long result = squareValue.applyAsLong(input);
        assertEquals(expected, result);
    }

    @Test
    public void whenNegativeInput_thenCorrect() {
        long input = -3L;
        long expectedDouble = -6L;
        long expectedSquare = 9L;

        long doubledResult = doubleValue.applyAsLong(input);
        long squaredResult = squareValue.applyAsLong(input);

        assertEquals(expectedDouble, doubledResult);
        assertEquals(expectedSquare, squaredResult);
    }

    @Test
    public void whenZeroInput_thenCorrect() {
        long input = 0L;

        long doubledResult = doubleValue.applyAsLong(input);
        long squaredResult = squareValue.applyAsLong(input);

        assertEquals(0L, doubledResult);
        assertEquals(0L, squaredResult);
    }
}
