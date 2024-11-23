package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.LongBinaryOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LongBinaryOperatorTest {

    private LongBinaryOperator addOperator;
    private LongBinaryOperator multiplyOperator;

    @BeforeEach
    public void setup() {
        addOperator = (a, b) -> a + b;
        multiplyOperator = (a, b) -> a * b;
    }

    @Test
    public void testAddition() {
        long result = addOperator.applyAsLong(5L, 10L);
        assertEquals(15L, result, "5 + 10 should equal 15");
    }

    @Test
    public void testMultiplication() {
        long result = multiplyOperator.applyAsLong(5L, 10L);
        assertEquals(50L, result, "5 * 10 should equal 50");
    }

    @Test
    public void testAdditionWithNegativeNumbers() {
        long result = addOperator.applyAsLong(-5L, 10L);
        assertEquals(5L, result, "-5 + 10 should equal 5");
    }

    @Test
    public void testMultiplicationWithNegativeNumbers() {
        long result = multiplyOperator.applyAsLong(-5L, 10L);
        assertEquals(-50L, result, "-5 * 10 should equal -50");
    }

    @Test
    public void testAdditionWithZero() {
        long result = addOperator.applyAsLong(0L, 10L);
        assertEquals(10L, result, "0 + 10 should equal 10");
    }

    @Test
    public void testMultiplicationWithZero() {
        long result = multiplyOperator.applyAsLong(0L, 10L);
        assertEquals(0L, result, "0 * 10 should equal 0");
    }
}

