package com.pedroperez.java8newfeatures.lambda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LambdaExpressionTest {
    @FunctionalInterface
    public interface MathOperation {
        int operate(int a, int b);
    }

    // Test addition operation using a lambda expression
    @Test
    public void testAddition() {
        MathOperation addition = Integer::sum;
        assertEquals(10, addition.operate(6, 4));
    }

    // Test subtraction operation using a lambda expression
    @Test
    public void testSubtraction() {
        MathOperation subtraction = (a, b) -> a - b;
        assertEquals(2, subtraction.operate(6, 4));
    }

    // Test multiplication operation using a lambda expression
    @Test
    public void testMultiplication() {
        MathOperation multiplication = (a, b) -> a * b;
        assertEquals(24, multiplication.operate(6, 4));
    }

    // Test division operation using a lambda expression
    @Test
    public void testDivision() {
        MathOperation division = (a, b) -> a / b;
        assertEquals(2, division.operate(8, 4));
    }

}
