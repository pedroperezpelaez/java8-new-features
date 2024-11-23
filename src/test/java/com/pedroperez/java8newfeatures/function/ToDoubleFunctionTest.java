package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoubleFunctionTest {

    private ToDoubleFunction<String> toDoubleFunction;

    @BeforeEach
    public void setup() {
        toDoubleFunction = Double::parseDouble;
    }

    @Test
    public void whenValidNumberString_thenCorrectDoubleValue() {
        double result = toDoubleFunction.applyAsDouble("123.45");
        assertEquals(123.45, result, 0.001);
    }

    @Test
    public void whenZeroString_thenZeroDoubleValue() {
        double result = toDoubleFunction.applyAsDouble("0");
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void whenNegativeNumberString_thenCorrectDoubleValue() {
        double result = toDoubleFunction.applyAsDouble("-123.45");
        assertEquals(-123.45, result, 0.001);
    }

    @Test
    public void whenScientificNotationString_thenCorrectDoubleValue() {
        double result = toDoubleFunction.applyAsDouble("1.23e2");
        assertEquals(123.0, result, 0.001);
    }
}
