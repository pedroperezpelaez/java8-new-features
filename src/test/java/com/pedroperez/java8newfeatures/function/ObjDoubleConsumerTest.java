package com.pedroperez.java8newfeatures.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.ObjDoubleConsumer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ObjDoubleConsumerTest {

    private ObjDoubleConsumer<String> objDoubleConsumer;

    @BeforeEach
    void setup() {
        // Create a mock instance of ObjDoubleConsumer
        objDoubleConsumer = mock(ObjDoubleConsumer.class);
    }

    @Test
    void testAccept() {
        // Arrange
        String testObject = "TestString";
        double testValue = 10.5;

        // Act
        objDoubleConsumer.accept(testObject, testValue);

        // Assert
        verify(objDoubleConsumer).accept(testObject, testValue);
    }

    @Test
    void testAcceptWithLogic() {
        // Using a real implementation of ObjDoubleConsumer for testing
        ObjDoubleConsumer<String> consumer = (str, value) -> {
            // Simple logic: appending the double value to the string
            System.out.println(str + value);
        };

        // You can use assert statements or capture output to validate the behavior
        consumer.accept("Value: ", 20.0);
        // Output should be "Value: 20.0"; validate using assertions if needed
    }
}


