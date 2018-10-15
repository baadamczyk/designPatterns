package pl.baadamczyk.designpatterns.behavioral.iterpreter;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value(staticConstructor = "of")
public class InterpretationResult {

    private List<String> aggregates;
    private Map<String, List<String>> commands;
    private Map<String, List<String>> events;
    private List<String> errors;
}
