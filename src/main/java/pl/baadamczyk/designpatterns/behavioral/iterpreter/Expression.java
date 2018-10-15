package pl.baadamczyk.designpatterns.behavioral.iterpreter;

public interface Expression {
    InterpretationResult interpret(String context);
}
