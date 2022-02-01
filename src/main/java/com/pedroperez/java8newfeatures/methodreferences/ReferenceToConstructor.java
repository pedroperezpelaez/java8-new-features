package com.pedroperez.java8newfeatures.methodreferences;

public class ReferenceToConstructor {


    private final String name;

    public ReferenceToConstructor(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
