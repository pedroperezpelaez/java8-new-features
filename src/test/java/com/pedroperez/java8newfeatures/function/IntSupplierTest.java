package com.pedroperez.java8newfeatures.function;
import org.junit.jupiter.api.Test;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntSupplierTest {

    @Test
    public void testIntSupplier() {
        IntSupplier supplier = () -> 42;  // Example IntSupplier that always returns 42

        int result = supplier.getAsInt();

        assertEquals(42, result, "The IntSupplier should return 42");
    }

    @Test
    public void testIntSupplierWithCounter() {
        // Example IntSupplier that uses an internal counter
        class Counter {
            private int count = 0;
            public int incrementAndGet() {
                return ++count;
            }
        }

        Counter counter = new Counter();
        IntSupplier supplier = counter::incrementAndGet;

        assertEquals(1, supplier.getAsInt(), "The IntSupplier should return 1 on first call");
        assertEquals(2, supplier.getAsInt(), "The IntSupplier should return 2 on second call");
        assertEquals(3, supplier.getAsInt(), "The IntSupplier should return 3 on third call");
    }
}
