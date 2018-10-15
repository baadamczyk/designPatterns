package pl.baadamczyk.designpatterns.behavioral.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmartHomeDriverTest {

  private SmartHomeDriver mediator;
  private Door frontDoor;
  private Door backDoor;
  private Door basementDoor;
  private Light kitchenLight;
  private Light bathroomLight;
  private Light bedroomLight;
  private Light hallLight;
  private Light basementLight;

  @BeforeEach
  private void setUp() {
    mediator = new SmartHomeDriver();
    frontDoor = new Door(DoorLocation.FRONT);
    backDoor = new Door(DoorLocation.BACK);
    basementDoor = new Door(DoorLocation.BASEMENT);
    kitchenLight = new Light(LightLocation.KITCHEN);
    bathroomLight = new Light(LightLocation.BATHROOM);
    bedroomLight = new Light(LightLocation.BEDROOM);
    hallLight = new Light(LightLocation.HALL);
    basementLight = new Light(LightLocation.BASEMENT);
  }

  @Test
  public void shouldCloseAllTheDoors() {
    mediator.registerDoor(Arrays.asList(frontDoor, backDoor, basementDoor));

    Command closeAllDoorsCommand = CloseAllDoorsCommand(mediator);

    assertThat(frontDoor.isClosed()).isTrue();
    assertThat(backDoor.isClosed()).isTrue();
    assertThat(basementDoor.isClosed()).isTrue();
  }

  @Test
  public void shouldOpenAllTheDoors() {
    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));

    Command openAllDoorsCommand = OpenAllDoors(mediator);

    assertThat(frontDoor.isClosed()).isFalse();
    assertThat(backDoor.isClosed()).isFalse();
    assertThat(basementDoor.isClosed()).isFalse();
  }

  @Test
  public void shouldTurnOffAllTheLights() {
    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    Command closeAllDoorsCommand = TurnOffAllLightsCommand(mediator);

    assertThat(kitchenLight.isOn()).isFalse();
    assertThat(bathroomLight.isOn()).isFalse();
    assertThat(bedroomLight.isOn()).isFalse();
    assertThat(hallLight.isOn()).isFalse();
    assertThat(basementLight.isOn()).isFalse();
  }

  @Test
  public void shouldTurnOnAllTheLights() {
    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    Command closeAllDoorsCommand = TurnOnAllLightsCommand(mediator);

    assertThat(kitchenLight.isOn()).isTrue();
    assertThat(bathroomLight.isOn()).isTrue();
    assertThat(bedroomLight.isOn()).isTrue();
    assertThat(hallLight.isOn()).isTrue();
    assertThat(basementLight.isOn()).isTrue();
  }

  @Test
  public void shouldOpenTheHome() {
    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));
    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    assertThat(frontDoor.isClosed()).isFalse();
    assertThat(backDoor.isClosed()).isFalse();
    assertThat(basementDoor.isClosed()).isFalse();
    assertThat(kitchenLight.isOn()).isTrue();
    assertThat(bathroomLight.isOn()).isTrue();
    assertThat(bedroomLight.isOn()).isTrue();
    assertThat(hallLight.isOn()).isTrue();
    assertThat(basementLight.isOn()).isTrue();
  }

  @Test
  public void shouldCloseTheHome() {
    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));
    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    assertThat(frontDoor.isClosed()).isTrue();
    assertThat(backDoor.isClosed()).isTrue();
    assertThat(basementDoor.isClosed()).isTrue();
    assertThat(kitchenLight.isOn()).isFalse();
    assertThat(bathroomLight.isOn()).isFalse();
    assertThat(bedroomLight.isOn()).isFalse();
    assertThat(hallLight.isOn()).isFalse();
    assertThat(basementLight.isOn()).isFalse();
  }
}
