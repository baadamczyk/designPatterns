package pl.baadamczyk.designpatterns.creational.builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarConfigurationTest {

  @Test
  public void shouldCreateCarWithFullSpecs() {
    CarConfiguration configuration =
        CarConfiguration.builder().color("Blue").fuelType("Diesel").tyreType("Summer").build();

    assertThat(configuration)
        .isNotNull()
        .extracting(
            c -> {
              return c.getTyreType();
            })
        .isEqualTo("Summer");
  }

  @Test
  public void shouldApplyDefaultColor_whenColorIsNotSelected() {
    CarConfiguration configuration =
        CarConfiguration.builder().fuelType("Diesel").tyreType("Summer").build();

    assertThat(configuration)
        .isNotNull()
        .extracting(
            c -> {
              return c.getColor();
            })
        .isEqualTo("White");
  }
}
