package pl.baadamczyk.designpatterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {

  @Test
  public void shouldCloneExistingInstance() {
    Vehicle firstInstance = Vehicle.of("Bike", 2);
    Vehicle secondInstance = (Vehicle) firstInstance.clone();

    assertThat(secondInstance).isNotNull().isEqualTo(firstInstance);
    assertThat(firstInstance == secondInstance).isFalse();
  }
}
