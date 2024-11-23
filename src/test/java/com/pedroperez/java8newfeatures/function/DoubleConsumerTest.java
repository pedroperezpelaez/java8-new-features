package com.pedroperez.java8newfeatures.function;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleConsumerTest {

    // Test DoubleConsumer: Print a double value (simulated by adding to a list)
    @Test
    public void testDoubleConsumerPrint() {
        List<Double> printedDoubles = new ArrayList<>();  // Capture printed output

        DoubleConsumer printDouble = printedDoubles::add;

        // Apply DoubleConsumer to "print" a double (by adding it to a list)
        printDouble.accept(10.5);
        printDouble.accept(20.5);

        assertEquals(Arrays.asList(10.5, 20.5), printedDoubles);
    }

    // Test DoubleConsumer: Add a double to a collection
    @Test
    public void testDoubleConsumerAddToList() {
        List<Double> list = new ArrayList<>();
        DoubleConsumer addToList = list::add;

        // Apply DoubleConsumer to add doubles to the list
        addToList.accept(5.5);
        addToList.accept(6.5);

        assertEquals(Arrays.asList(5.5, 6.5), list);
    }

    // Test DoubleConsumer: Multiply a double value and store it
    @Test
    public void testDoubleConsumerMultiplyAndStore() {
        List<Double> results = new ArrayList<>();
        DoubleConsumer multiplyAndStore = d -> results.add(d * 2);

        // Apply DoubleConsumer to multiply a double and store the result
        multiplyAndStore.accept(3.0);
        multiplyAndStore.accept(4.5);

        assertEquals(Arrays.asList(6.0, 9.0), results);
    }

    // Test DoubleConsumer: Append a double to a StringBuilder
    @Test
    public void testDoubleConsumerAppendToStringBuilder() {
        StringBuilder sb = new StringBuilder();
        DoubleConsumer appendToStringBuilder = sb::append;

        // Apply DoubleConsumer to append doubles to StringBuilder
        appendToStringBuilder.accept(1.5);
        appendToStringBuilder.accept(2.5);

        assertEquals("1.52.5", sb.toString());
    }
}
