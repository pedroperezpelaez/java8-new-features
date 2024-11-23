package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.LongSupplier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongSupplierTest {

    private LongSupplier longSupplier;

    @BeforeEach
    public void setUp() {
        // Example LongSupplier that returns a constant value
        longSupplier = () -> 42L;
    }

    @Test
    public void testLongSupplierReturnsCorrectValue() {
        long result = longSupplier.getAsLong();
        assertEquals(42L, result, "LongSupplier should return the expected constant value.");
    }

    @Test
    public void testCustomLogicLongSupplier() {
        // Another example: LongSupplier that returns the current time in milliseconds
        LongSupplier currentTimeSupplier = System::currentTimeMillis;

        // Just an example to call the supplier; typically, you would mock or control timing.
        long currentTime = currentTimeSupplier.getAsLong();

        // Test: Since time is dynamic, we can't assert an exact value, but you might check range
        // This is a placeholder example as asserting time can be quite tricky in tests
        assertEquals(true, currentTime > 0, "The current time should be greater than zero.");
    }
}

