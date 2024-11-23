package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.IntBinaryOperator;

public class IntBinaryOperatorTest {

    private IntBinaryOperator addOperator;
    private IntBinaryOperator subtractOperator;

    @BeforeEach
    public void setup() {
        addOperator = (a, b) -> a + b;
        subtractOperator = (a, b) -> a - b;
    }

    @Test
    public void testAddOperator() {
        int result = addOperator.applyAsInt(3, 5);
        assertEquals(8, result, "3 + 5 should equal 8");
    }

    @Test
    public void testSubtractOperator() {
        int result = subtractOperator.applyAsInt(5, 3);
        assertEquals(2, result, "5 - 3 should equal 2");
    }

    @Test
    public void testAddOperatorWithNegativeNumbers() {
        int result = addOperator.applyAsInt(-2, 3);
        assertEquals(1, result, "-2 + 3 should equal 1");
    }

    @Test
    public void testSubtractOperatorWithNegativeNumbers() {
        int result = subtractOperator.applyAsInt(-2, 3);
        assertEquals(-5, result, "-2 - 3 should equal -5");
    }

    @Test
    public void testAddOperatorWithZero() {
        int result = addOperator.applyAsInt(0, 5);
        assertEquals(5, result, "0 + 5 should equal 5");
    }
}

