package pl.baadamczyk.designpatterns.creational.abstractFactory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarFactoryTest {

  @Test
  public void shouldReturnConcreteFactory_whenSupportedArgumentIsPassed() {
    CarFactory factory = CarFactory.getInstance(Brand.AUDI);

    assertThat(factory).isNotNull();
  }

  @Test
  public void shouldThrowAnException_whenUnsupportedArgumentIsPassed() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> CarFactory.getInstance(Brand.SAAB))
        .withMessage("There is no factory for given brand");
  }

  @Test
  public void shouldReturnCar_whenValidArgsArePassed() {
    Car car = CarFactory.getInstance(Brand.AUDI).getCarInstance(Type.COUPE);

    assertThat(car)
            .isNotNull()
            .hasFieldOrPropertyWithValue("type", "COUPE")
            .hasFieldOrPropertyWithValue("modelName", "S5");
  }
}
