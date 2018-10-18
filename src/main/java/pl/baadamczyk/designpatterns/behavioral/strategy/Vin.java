package pl.baadamczyk.designpatterns.behavioral.strategy;

import lombok.Getter;
import lombok.Setter;

public class Vin {

  @Getter @Setter private String vin;
  private ValidationStrategy strategy;

  public Vin(ValidationStrategy strategy) {
    this.strategy = strategy;
  }

  public boolean isValid() {
    return strategy.isValid(this);
  }
}
