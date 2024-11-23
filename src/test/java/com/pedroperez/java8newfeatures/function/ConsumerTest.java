package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsumerTest {

    // Test Consumer: Print an integer
    @Test
    public void testConsumerPrintInteger() {
        List<Integer> printedNumbers = new ArrayList<>();  // Capture printed output

        Consumer<Integer> printInteger = printedNumbers::add;

        // Apply Consumer to print an integer
        printInteger.accept(10);
        printInteger.accept(20);

        assertEquals(Arrays.asList(10, 20), printedNumbers);
    }

    // Test Consumer: Add an element to a collection
    @Test
    public void testConsumerAddToList() {
        List<String> list = new ArrayList<>();
        Consumer<String> addToList = list::add;

        // Apply Consumer to add elements to the list
        addToList.accept("Hello");
        addToList.accept("World");

        assertEquals(Arrays.asList("Hello", "World"), list);
    }

    // Test Consumer: Convert a string to uppercase and store it
    @Test
    public void testConsumerToUpperCase() {
        List<String> result = new ArrayList<>();
        Consumer<String> toUpperCaseAndStore = s -> result.add(s.toUpperCase());

        // Apply Consumer to convert strings to uppercase
        toUpperCaseAndStore.accept("java");
        toUpperCaseAndStore.accept("lambda");

        assertEquals(Arrays.asList("JAVA", "LAMBDA"), result);
    }

    // Test Consumer: Append an integer to a StringBuilder
    @Test
    public void testConsumerAppendToStringBuilder() {
        StringBuilder sb = new StringBuilder();
        Consumer<Integer> appendToStringBuilder = sb::append;

        // Apply Consumer to append integers to StringBuilder
        appendToStringBuilder.accept(100);
        appendToStringBuilder.accept(200);

        assertEquals("100200", sb.toString());
    }

    @Test
    public void testProcessMessage() {
        // Arrange
        MessageProcessor processor = new MessageProcessor();
        List<String> processedMessages = new ArrayList<>();

        // Create a Consumer that adds the message to the list
        Consumer<String> messageConsumer = processedMessages::add;

        // Act
        processor.processMessage("Hello, World!", messageConsumer);

        // Assert
        assertEquals(1, processedMessages.size());
        assertEquals("Hello, World!", processedMessages.get(0));
    }

    public static class MessageProcessor {

        public void processMessage(String message, Consumer<String> consumer) {
            consumer.accept(message);
        }
    }

}
