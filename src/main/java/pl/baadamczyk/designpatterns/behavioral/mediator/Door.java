package pl.baadamczyk.designpatterns.behavioral.mediator;

import lombok.Data;

@Data
public class Door {

  private DoorLocation location;
  private boolean isClosed;

  public Door(DoorLocation location) {
    this.location = location;
    isClosed = false;
  }
}
