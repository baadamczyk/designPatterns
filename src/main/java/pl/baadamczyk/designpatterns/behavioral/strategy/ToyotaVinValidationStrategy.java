package pl.baadamczyk.designpatterns.behavioral.strategy;

import lombok.extern.java.Log;

@Log
public class ToyotaVinValidationStrategy extends ValidationStrategy {

  @Override
  public boolean isValid(Vin vin) {
    boolean isValid = validateLength(vin);

    if (isValid) {
      return validateManufacturer(vin);
    }

    return isValid;
  }

  @Override
  public boolean validateManufacturer(Vin vin) {

    return vin.getVin().substring(1, 2).equals("T");
  }
}
