package pl.baadamczyk.designpatterns.behavioral.strategy;

public class FalseStrategy extends ValidationStrategy {
  @Override
  public boolean isValid(Vin vin) {
    return false;
  }

  @Override
  public boolean validateManufacturer(Vin vin) {
    return false;
  }
}
