package com.pedroperez.java8newfeatures.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A sample annotation applicable to type uses and type parameters.
 * Marked with RUNTIME retention so we can inspect it via reflection in tests.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface TypeCustom {
    String value() default "default"; // Optional value
}