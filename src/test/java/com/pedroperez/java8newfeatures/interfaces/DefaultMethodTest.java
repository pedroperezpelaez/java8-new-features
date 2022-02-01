package com.pedroperez.java8newfeatures.interfaces;

import com.pedroperez.java8newfeatures.interfaces.DefaultMethod;
import com.pedroperez.java8newfeatures.interfaces.DefaultMethodImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultMethodTest {

    @Test
    public void testDefaultMethod(){
        DefaultMethod defaultMethod= new DefaultMethodImpl();
        assertThat(defaultMethod.getDefault()).isEqualTo("Default method in interfaces ");
    }
}
