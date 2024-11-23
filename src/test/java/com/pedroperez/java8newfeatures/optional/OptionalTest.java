package com.pedroperez.java8newfeatures.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {
    @Test
    public void testOptionalCreation() {
        // Create Optional
        Optional<String> optionalString = Optional.of("Hello, World!");

        // Check if value is present
        assertTrue(optionalString.isPresent());

        // Get value from Optional
        assertEquals("Hello, World!", optionalString.get());
    }

    @Test
    public void testOptionalEmpty() {
        // Create an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Check if value is absent
        assertFalse(emptyOptional.isPresent());

        // Provide a default value if Optional is empty
        assertEquals("Default", emptyOptional.orElse("Default"));
    }

    @Test
    public void testOptionalOrElseThrow() {
        Optional<String> emptyOptional = Optional.empty();

        // Expect an exception to be thrown if Optional is empty
        assertThrows(RuntimeException.class,
                () -> emptyOptional.orElseThrow(RuntimeException::new));
    }

    @Test
    public void testOptionalOrElseGet() {
        Optional<String> emptyOptional = Optional.empty();

        // Use a Supplier to generate a default value
        assertEquals("Generated", emptyOptional.orElse("Generated"));
    }
}
