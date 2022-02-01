package com.pedroperez.java8newfeatures.interfaces;

import com.pedroperez.java8newfeatures.interfaces.StaticMethod;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StaticMethodTest {

    @Test
    public void testStaticMethod(){
        assertThat(StaticMethod.getStatic()).isEqualTo("Static method in interface");
    }
}
