package pl.baadamczyk.designpatterns.creational.factory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class CarFactoryTest {

  @Test
  public void shouldCreateNewSuvInstance_whenSuvTypeIsRequested() {
    Car car = CarFactory.getInstance("SUV");

    assertThat(car)
        .isNotNull()
        .hasFieldOrPropertyWithValue("type", "SUV")
        .hasFieldOrPropertyWithValue("modelName", "Stelvio");
  }

  @Test
  public void shouldCreateCoupeInstance_whenCoupeTypeIsRequested() {
    Car car = CarFactory.getInstance("COUPE");

    assertThat(car)
        .isNotNull()
        .hasFieldOrPropertyWithValue("type", "COUPE")
        .hasFieldOrPropertyWithValue("modelName", "GT");
  }

  @Test
  public void shouldThrowAnException_whenUnsupportedTypeIsRequested() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> CarFactory.getInstance("Bike"))
        .withMessage("Car type not supported");
  }
}
