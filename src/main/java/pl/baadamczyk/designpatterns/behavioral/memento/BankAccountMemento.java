package pl.baadamczyk.designpatterns.behavioral.memento;

import lombok.Value;

@Value(staticConstructor = "of")
public class BankAccountMemento {

    private float state;
}
