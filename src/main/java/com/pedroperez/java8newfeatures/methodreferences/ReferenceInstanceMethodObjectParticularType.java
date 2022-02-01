package com.pedroperez.java8newfeatures.methodreferences;

import java.util.List;
import java.util.stream.Collectors;

public class ReferenceInstanceMethodObjectParticularType {

    public List<String> filterNotEmptyStrings(final List<String> list) {
        //we can use ContainingType::methodName
        return list.stream().filter(String::isEmpty).collect(Collectors.toList());
    }

}
