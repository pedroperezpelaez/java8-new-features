package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleFunctionTest {

    // Test DoubleFunction: Convert a double to a string
    @Test
    public void testDoubleFunctionToString() {
        DoubleFunction<String> doubleToString = d -> "Value: " + d;

        // Apply DoubleFunction to convert double to string
        String result = doubleToString.apply(10.5);

        assertEquals("Value: 10.5", result);
    }

    @Test
    public void testDoubleFunctionInStream() {
        DoubleFunction<Boolean> doubleToBool = d -> d > 3.0;


        List<Double> doubleList = new ArrayList<>(Arrays.asList(2.2, 3.3, 4.4));
        // Method invocation context
        Stream<Double> result = doubleList.stream().filter(doubleToBool::apply);
        assertEquals(2, result.count());
        // Cast context stream. map((ToIntFunction) e -> e. getSize())
    }

    // Test DoubleFunction: Convert a double to its square value (as an integer)
    @Test
    public void testDoubleFunctionSquareAsInteger() {
        DoubleFunction<Integer> squareAsInteger = d -> (int) (d * d);

        // Apply DoubleFunction to get square of double as an integer
        int result = squareAsInteger.apply(4.0);

        assertEquals(16, result);
    }

    // Test DoubleFunction: Convert a double to a formatted string with two decimal places
    @Test
    public void testDoubleFunctionToFormattedString() {
        DoubleFunction<String> toFormattedString = d -> String.format("%.2f", d);

        // Apply DoubleFunction to format a double to 2 decimal places
        String result = toFormattedString.apply(123.456);

        assertEquals("123.46", result);
    }

    // Test DoubleFunction: Convert a double to its absolute value as a string
    @Test
    public void testDoubleFunctionAbsoluteValueAsString() {
        DoubleFunction<String> absoluteValueAsString = d -> "Absolute: " + Math.abs(d);

        // Apply DoubleFunction to get absolute value of double as a string
        String result = absoluteValueAsString.apply(-15.7);

        assertEquals("Absolute: 15.7", result);
    }
}

