package pl.baadamczyk.designpatterns.behavioral.observer;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WateringJet extends Observer {

  @Getter() private boolean isSpraying;

  public WateringJet(Subject subject, boolean initialState) {
    this.subject = subject;
    subject.attach(this);
  }

  // Update status of observer, when message about update is sent from subject
  @Override
  public void update() {
    isSpraying = (SystemStatus.ON.equals(subject.getState()));
  }

  //Observer is also able to send messages/events!
  public void reportError() {
    // Reporting the error and performing emergency shutdown
    log.error("Water jet malfunction. Stopping the system...");
    subject.setState(SystemStatus.OFF);
  }
}
