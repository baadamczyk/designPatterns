package pl.baadamczyk.designpatterns.behavioral.interpreter;

import com.google.common.base.Splitter;

import java.util.List;

public class SyntaxUtility {

    public static List<String> tokenize(String controlStructure) {
        return Splitter.on(" ").splitToList(controlStructure);
    }
}
