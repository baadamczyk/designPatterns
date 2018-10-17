package pl.baadamczyk.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    public abstract void setState(SystemStatus status);
    public abstract SystemStatus getState();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void sendStatusMessage() {
        observers.stream().forEach(s -> s.update());
    }
}
