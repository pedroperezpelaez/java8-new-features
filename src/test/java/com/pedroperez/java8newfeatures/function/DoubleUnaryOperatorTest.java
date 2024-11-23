package com.pedroperez.java8newfeatures.function;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.function.DoubleUnaryOperator;

public class DoubleUnaryOperatorTest {

    @Test
    public void testSquareOperator() {
        // Given
        DoubleUnaryOperator squareOperator = x -> x * x;

        // When
        double result = squareOperator.applyAsDouble(4.0);

        // Then
        assertEquals(16.0, result, 0.0001);
    }

    @Test
    public void testSquareOperatorWithZero() {
        // Given
        DoubleUnaryOperator squareOperator = x -> x * x;

        // When
        double result = squareOperator.applyAsDouble(0.0);

        // Then
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    public void testSquareOperatorWithNegativeNumber() {
        // Given
        DoubleUnaryOperator squareOperator = x -> x * x;

        // When
        double result = squareOperator.applyAsDouble(-5.0);

        // Then
        assertEquals(25.0, result, 0.0001);
    }
}
