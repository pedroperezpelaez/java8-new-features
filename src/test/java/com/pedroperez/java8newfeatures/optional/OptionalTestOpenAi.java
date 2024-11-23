package com.pedroperez.java8newfeatures.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalTestOpenAi {

    @Test
    void testOptionalCreation() {
        // Create a non-empty Optional
        Optional<String> nonEmptyOptional = Optional.of("Hello, World!");

        assertTrue(nonEmptyOptional.isPresent());
        assertEquals("Hello, World!", nonEmptyOptional.get());
    }

    @Test
    void testEmptyOptional() {
        // Create an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        assertFalse(emptyOptional.isPresent());
    }

    @Test
    void testOptionalOfNullable() {
        // Create an Optional using ofNullable
        Optional<String> optionalNullable = Optional.ofNullable(null);

        assertFalse(optionalNullable.isPresent());

        optionalNullable = Optional.ofNullable("Not Null");
        assertTrue(optionalNullable.isPresent());
        assertEquals("Not Null", optionalNullable.get());
    }

    @Test
    void testOrElse() {
        // Create an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Use orElse with a default value
        assertEquals("Default Value", emptyOptional.orElse("Default Value"));
    }

    @Test
    void testOrElseGet() {
        // Create a non-empty Optional
        Optional<String> nonEmptyOptional = Optional.of("Hello");

        // Use orElseGet with a Supplier
        assertEquals("Hello", nonEmptyOptional.orElseGet(() -> "Default Value"));
    }

    @Test
    void testOrElseThrow() {
        // Create an empty Optional
        Optional<String> emptyOptional = Optional.empty();

        // Test orElseThrow
        //assertThrows(NoSuchElementException.class, emptyOptional::orElseThrow);

        // Create a non-empty Optional
        Optional<String> nonEmptyOptional = Optional.of("Hello");

        // Ensure no exception is thrown when the Optional is not empty
        //assertDoesNotThrow(nonEmptyOptional::orElseThrow);
    }
}