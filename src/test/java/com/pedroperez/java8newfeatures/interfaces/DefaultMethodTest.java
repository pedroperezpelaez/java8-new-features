package com.pedroperez.java8newfeatures.interfaces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultMethodTest {

    @Test
    public void testDefaultMethod() {
        DefaultMethod defaultMethod = new DefaultMethodImpl();
        assertThat(defaultMethod.getDefault()).isEqualTo("Default method in interfaces ");
    }
}
