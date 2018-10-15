package pl.baadamczyk.designpatterns.behavioral.mediator;

import lombok.Data;

@Data
public class Light {

  private LightLocation location;
  private boolean isOn;

  public Light(LightLocation location) {
    this.location = location;
    isOn = false;
  }
}
