package pl.baadamczyk.designpatterns.behavioral.statemachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InRepairCarTest {

  private Car inRepairCar;

  @BeforeEach
  public void setUp() {
    inRepairCar = new Car();
  }

  @Test
  public void shouldBeInReceivedState_whenReceived_givenQueuedState() {
    inRepairCar.takeUp();
    State carState = inRepairCar.getState();

    assertThat(carState.getClass().getSimpleName()).isEqualTo("CarTakenUpState");
  }

  @Test
  public void shouldbeInDiagnosedState_whenDiagnosed_givenReceivedState() {
    inRepairCar.takeUp();
    inRepairCar.diagnose();
    State carState = inRepairCar.getState();

    assertThat(carState.getClass().getSimpleName()).isEqualTo("CarDiagnosedState");
  }

  @Test
  public void shouldBeInRepairedState_whenRepaired_givenDiagnosedState() {
    inRepairCar.takeUp();
    inRepairCar.diagnose();
    inRepairCar.repair();
    State carState = inRepairCar.getState();

    assertThat(carState.getClass().getSimpleName()).isEqualTo("CarRepairedState");
  }
}
