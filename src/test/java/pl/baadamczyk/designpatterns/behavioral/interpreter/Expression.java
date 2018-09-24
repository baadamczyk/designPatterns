package pl.baadamczyk.designpatterns.behavioral.interpreter;

public interface Expression {
    InterpretationResult interpret(String context);
}
