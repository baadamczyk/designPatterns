package pl.baadamczyk.designpatterns.behavioral.interpreter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class TokenWrapper {

    @Getter
    private List<String> aggregates;
    @Getter
    private List<String> commands;
    @Getter
    private List<String> events;

    public TokenWrapper() {
        this.aggregates = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public void addAggregate(String aggregate) {
        aggregates.add(aggregate);
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void addEvent(String event) {
        events.add(event);
    }

    @Override
    public String toString() {
        return "TokenWrapper{" +
                "aggregates=" + aggregates +
                ", commands=" + commands +
                ", events=" + events +
                '}';
    }
}
