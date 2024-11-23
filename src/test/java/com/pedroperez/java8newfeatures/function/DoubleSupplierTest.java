package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.DoubleSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DoubleSupplierTest {

    private DoubleSupplier doubleSupplier;

    @BeforeEach
    public void setUp() {
        // Initialize the DoubleSupplier with a lambda expression or method reference
        doubleSupplier = () -> 4.5;
    }

    @Test
    public void testGetAsDouble() {
        // Using DoubleSupplier to get a double value
        double result = doubleSupplier.getAsDouble();

        // Assert that the result is what you expect
        assertEquals(4.5, result, 0.001); // 0.001 is the delta for floating-point comparison
    }
}

