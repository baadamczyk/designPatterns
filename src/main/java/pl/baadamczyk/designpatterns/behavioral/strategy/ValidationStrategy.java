package pl.baadamczyk.designpatterns.behavioral.strategy;

public abstract class ValidationStrategy {

  public abstract boolean isValid(Vin vin);

  public abstract boolean validateManufacturer(Vin vin);

  protected boolean validateLength(Vin vin) {
    return vin.getVin().length() == 17;
  }
}
