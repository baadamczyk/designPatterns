package pl.baadamczyk.designpatterns.behavioral.statemachine;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

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

  @SneakyThrows
  public void takeUp() {
    if (state.equals(this.queuedState)) {
      state.handleRequest();
    } else {
      throw new InvalidStateException();
    }
  }

  @SneakyThrows
  public void diagnose() {
    if (state.equals(this.takenUpState)) {
      state.handleRequest();
    } else {
      throw new InvalidStateException();
    }
  }

  @SneakyThrows
  public void repair() {
    if (state.equals(this.diagnosedState)) {
      state.handleRequest();
    } else {
      throw new InvalidStateException();
    }
  }
}
