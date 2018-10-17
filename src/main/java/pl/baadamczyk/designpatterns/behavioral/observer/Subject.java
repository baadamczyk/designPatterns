package pl.baadamczyk.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

  private List<Observer> observers = new ArrayList<>();

  public abstract SystemStatus getState();

  public abstract void setState(SystemStatus status);

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void detach(Observer observer) {
    observers.remove(observer);
  }

  // Send message to all registred observers (execute every registered observer's 'update' method
  public void sendStatusMessage() {
    observers.stream().forEach(s -> s.update());
  }
}
