package pl.baadamczyk.designpatterns.behavioral.observer;

import lombok.Getter;

public class WateringJet extends Observer {

  @Getter()
  private boolean isSpraying;

  public WateringJet(Subject subject, boolean initialState) {
    this.subject = subject;
    subject.attach(this);
  }

  @Override
  public void update() {
    isSpraying = (SystemStatus.ON.equals(subject.getState()));
  }
}
