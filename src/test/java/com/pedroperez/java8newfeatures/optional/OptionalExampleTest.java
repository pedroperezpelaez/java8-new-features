package com.pedroperez.java8newfeatures.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OptionalExample {

    public Optional<String> getUserName(String user) {
        if (user != null && !user.isEmpty()) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Integer> parseStringToInt(String numberStr) {
        try {
            return Optional.of(Integer.parseInt(numberStr));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

public class OptionalExampleTest {

    private final OptionalExample optionalExample = new OptionalExample();

    @Test
    public void getUserName_ShouldReturnEmpty_WhenUserIsNull() {
        Optional<String> result = optionalExample.getUserName(null);
        assertFalse(result.isPresent());
    }

    @Test
    public void getUserName_ShouldReturnEmpty_WhenUserIsEmptyString() {
        Optional<String> result = optionalExample.getUserName("");
        assertFalse(result.isPresent());
    }

    @Test
    public void getUserName_ShouldReturnOptionalWithUsername_WhenValidUsernameProvided() {
        String username = "JohnDoe";
        Optional<String> result = optionalExample.getUserName(username);
        assertTrue(result.isPresent());
        assertEquals(username, result.get());
    }

    @Test
    public void parseStringToInt_ShouldReturnEmpty_WhenInvalidNumberString() {
        Optional<Integer> result = optionalExample.parseStringToInt("abc");
        assertFalse(result.isPresent());
    }

    @Test
    public void parseStringToInt_ShouldReturnOptionalWithParsedInteger_WhenValidNumberString() {
        String numberStr = "123";
        int expectedValue = 123;
        Optional<Integer> result = optionalExample.parseStringToInt(numberStr);
        assertTrue(result.isPresent());
        assertEquals(expectedValue, result.get());
    }
}
