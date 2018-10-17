package pl.baadamczyk.designpatterns.behavioral.statemachine;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarQueuedState implements State {

  private Car car;

  @Override
  public void handleRequest() {

    // Any logic that is related to this state class can be placed here. Right now, for PoC purposes
    // it's status change only
    car.setState(car.getTakenUpState());
  }
}
