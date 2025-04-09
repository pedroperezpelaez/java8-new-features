package com.pedroperez.java8newfeatures.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Container annotation for repeating annotations
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tags {
    Tag[] value();
}

