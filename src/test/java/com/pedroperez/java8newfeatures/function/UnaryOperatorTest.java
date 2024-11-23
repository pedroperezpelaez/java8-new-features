package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnaryOperatorTest {

    private UnaryOperator<Integer> squareOperator;
    private UnaryOperator<String> reverseStringOperator;

    @BeforeEach
    public void setup() {
        // UnaryOperator that squares an integer
        squareOperator = num -> num * num;

        // UnaryOperator that reverses a string
        reverseStringOperator = str -> new StringBuilder(str).reverse().toString();
    }

    @Test
    public void whenSquare_thenCorrect() {
        Integer result = squareOperator.apply(4);
        assertEquals(16, result, "Square of 4 should be 16");
    }

    @Test
    public void whenSquareNegative_thenCorrect() {
        Integer result = squareOperator.apply(-3);
        assertEquals(9, result, "Square of -3 should be 9");
    }

    @Test
    public void whenReverseString_thenCorrect() {
        String result = reverseStringOperator.apply("hello");
        assertEquals("olleh", result, "Reversing 'hello' should produce 'olleh'");
    }

    @Test
    public void whenReverseEmptyString_thenCorrect() {
        String result = reverseStringOperator.apply("");
        assertEquals("", result, "Reversing an empty string should produce an empty string");
    }
}

