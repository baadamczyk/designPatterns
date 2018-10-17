package pl.baadamczyk.designpatterns.behavioral.statemachine;

import lombok.Getter;
import lombok.Setter;
import sun.plugin.dom.exception.InvalidStateException;

@Getter
public class Car {

  private State queuedState;
  private State takenUpState;
  private State diagnosedState;
  private State repairedState;

  @Setter private State state;

  public Car() {
    queuedState = new CarQueuedState(this);
    takenUpState = new CarTakenUpState(this);
    diagnosedState = new CarDiagnosedState(this);
    repairedState = new CarRepairedState(this);

    this.state = queuedState;
  }

  public void takeUp() {
    if (state.equals(this.queuedState)) {
      state.handleRequest();
    } else {
      throw new InvalidStateException("This operation is not allowed for car of current state!");
    }
  }

  public void diagnose() {
    if (state.equals(this.takenUpState)) {
      state.handleRequest();
    } else {
      throw new InvalidStateException("This operation is not allowed for car of current state!");
    }
  }

  public void repair() {
    if (state.equals(this.diagnosedState)) {
      state.handleRequest();
    } else {
      throw new InvalidStateException("This operation is not allowed for car of current state!");
    }
  }
}
