package pl.baadamczyk.designpatterns.behavioral.strategy;

public class AudiVinValidationStrategy extends ValidationStrategy {

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
    String vinString = vin.getVin();
    return vinString.substring(1, 3).equals("AU");
  }
}
