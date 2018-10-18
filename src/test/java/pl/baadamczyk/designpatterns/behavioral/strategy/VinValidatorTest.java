package pl.baadamczyk.designpatterns.behavioral.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VinValidatorTest {

  @Test
  public void shouldvalidateVin_givenARValidationStrategy() {
    Vin vin = new Vin(new AlfaRomeoVinValidationStrategy());
    vin.setVin("ZARAA6692E1005881");

    assertThat(vin.isValid()).isTrue();
  }

  @Test
  public void shouldValidateVin_givenToyotaValidationStrategy() {
    Vin vin = new Vin(new ToyotaVinValidationStrategy());
    vin.setVin("4T1BE32K35U614028");

    assertThat(vin.isValid()).isTrue();
  }

  @Test
  public void shouldValidateVin_givenAudiValidationStrategy() {
    Vin vin = new Vin(new AudiVinValidationStrategy());
    vin.setVin("WAUZZZ8K6AA103083");

    assertThat(vin.isValid()).isTrue();
  }

  @Test
  public void shouldNotValidateVin_givenVinOfInvalidLength() {
    Vin vin = new Vin(new AudiVinValidationStrategy());
    vin.setVin("WAUZZZ8103083");

    assertThat(vin.isValid()).isFalse();
  }

  @Test
  public void shouldNotValidateVin_givenUnsupportedOrInvalidVin() {
    Vin vin = new Vin(new AudiVinValidationStrategy());
    vin.setVin("19UYA31581L000000");

    assertThat(vin.isValid()).isFalse();
  }
}
