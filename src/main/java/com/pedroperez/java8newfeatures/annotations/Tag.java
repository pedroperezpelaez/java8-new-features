package com.pedroperez.java8newfeatures.annotations;

import java.lang.annotation.*;

// Repeating annotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Tags.class)
public @interface Tag {
    String value();
}
