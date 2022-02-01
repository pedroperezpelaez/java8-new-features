package com.pedroperez.java8newfeatures.interfaces;

public interface DefaultMethod {
    default String getDefault() {
        return "Default method in interfaces ";
    }
}
