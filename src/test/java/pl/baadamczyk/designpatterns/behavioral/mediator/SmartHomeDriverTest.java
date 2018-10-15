package pl.baadamczyk.designpatterns.behavioral.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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
    frontDoor.setClosed(false);
    backDoor.setClosed(false);
    basementDoor.setClosed(false);

    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));

    Command closeAllDoorsCommand = new CloseAllDoorsCommand(mediator);
    closeAllDoorsCommand.execute();

    assertThat(frontDoor.isClosed()).isTrue();
    assertThat(backDoor.isClosed()).isTrue();
    assertThat(basementDoor.isClosed()).isTrue();
  }

  @Test
  public void shouldOpenAllTheDoors() {
    frontDoor.setClosed(true);
    backDoor.setClosed(true);
    basementDoor.setClosed(true);

    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));

    Command openAllDoorsCommand = new OpenAllDoors(mediator);
    openAllDoorsCommand.execute();

    assertThat(frontDoor.isClosed()).isFalse();
    assertThat(backDoor.isClosed()).isFalse();
    assertThat(basementDoor.isClosed()).isFalse();
  }

  @Test
  public void shouldTurnOffAllTheLights() {
    kitchenLight.setOn(true);
    bathroomLight.setOn(true);
    bedroomLight.setOn(true);
    hallLight.setOn(true);
    bathroomLight.setOn(true);


    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    Command turnOffAllLightsCommand = new TurnOffAllLightsCommand(mediator);
    turnOffAllLightsCommand.execute();

    assertThat(kitchenLight.isOn()).isFalse();
    assertThat(bathroomLight.isOn()).isFalse();
    assertThat(bedroomLight.isOn()).isFalse();
    assertThat(hallLight.isOn()).isFalse();
    assertThat(basementLight.isOn()).isFalse();
  }

  @Test
  public void shouldTurnOnAllTheLights() {
    kitchenLight.setOn(false);
    bathroomLight.setOn(false);
    bedroomLight.setOn(false);
    hallLight.setOn(false);
    bathroomLight.setOn(false);

    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
    turnOnAllLightsCommand.execute();

    assertThat(kitchenLight.isOn()).isTrue();
    assertThat(bathroomLight.isOn()).isTrue();
    assertThat(bedroomLight.isOn()).isTrue();
    assertThat(hallLight.isOn()).isTrue();
    assertThat(basementLight.isOn()).isTrue();
  }

  @Test
  public void shouldOpenTheHome() {
    frontDoor.setClosed(true);
    backDoor.setClosed(true);
    basementDoor.setClosed(true);
    kitchenLight.setOn(false);
    bathroomLight.setOn(false);
    bedroomLight.setOn(false);
    hallLight.setOn(false);
    bathroomLight.setOn(false);

    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));
    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    Command openTheHomeCommand = new OpenTheHomeCommand(mediator);
    openTheHomeCommand.execute();

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
    frontDoor.setClosed(false);
    backDoor.setClosed(false);
    basementDoor.setClosed(false);
    kitchenLight.setOn(true);
    bathroomLight.setOn(true);
    bedroomLight.setOn(true);
    hallLight.setOn(true);
    bathroomLight.setOn(true);

    mediator.registerDoors(Arrays.asList(frontDoor, backDoor, basementDoor));
    mediator.registerLights(
        Arrays.asList(kitchenLight, bathroomLight, bedroomLight, hallLight, basementLight));

    Command closeTheHomeCommand = new CloseTheHomeCommand(mediator);
    closeTheHomeCommand.execute();

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
