package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooleanSupplierTest {
    // Test BooleanSupplier: Check if a number is positive
    @Test
    public void testBooleanSupplierIsPositive() {
        BooleanSupplier isPositive;

        int number = 10;
        isPositive = () -> number > 0;
        // Apply BooleanSupplier to check if the number is positive
        assertTrue(isPositive.getAsBoolean());
    }

    // Test BooleanSupplier: Check if a collection is empty
    @Test
    public void testBooleanSupplierIsCollectionEmpty() {
        List<String> list = new ArrayList<>();
        BooleanSupplier isListEmpty = list::isEmpty;

        // Apply BooleanSupplier to check if the list is empty
        assertTrue(isListEmpty.getAsBoolean());

        list.add("item");
        assertFalse(isListEmpty.getAsBoolean());
    }

    // Test BooleanSupplier: Check if a string starts with a specific character
    @Test
    public void testBooleanSupplierStringStartsWith() {
        String text = "Lambda";
        String startChar = "L";
        BooleanSupplier startsWith = () -> text.startsWith(startChar);

        // Apply BooleanSupplier to check if the string starts with 'L'
        assertTrue(startsWith.getAsBoolean());
    }

}
