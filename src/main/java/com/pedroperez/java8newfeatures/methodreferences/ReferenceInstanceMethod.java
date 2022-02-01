package com.pedroperez.java8newfeatures.methodreferences;

public class ReferenceInstanceMethod {
    public boolean isValidNumber(final String text) {
        try {
            Integer.valueOf(text);
        } catch (final NumberFormatException e) {
            return false;
        }
        return true;
    }
}
