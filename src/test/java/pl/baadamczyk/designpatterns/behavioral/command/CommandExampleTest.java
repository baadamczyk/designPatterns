package pl.baadamczyk.designpatterns.behavioral.command;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandExampleTest {

  @Test
  public void shouldLockTheDoor_whenLockCommandIsSent() {
    Car car = Car.ofState(false, false);
    RemoteController controller = new RemoteController(car);

    Command lockDoorCommand = new LockUnlockDoorCommand(car);
    controller.dispatch(lockDoorCommand);

    assertThat(car)
        .hasFieldOrPropertyWithValue("areDoorLocked", true)
        .hasFieldOrPropertyWithValue("areDoorOpen", false);
  }

  @Test
  public void shouldUnlockTheDoor_whenUnlockCommandIsSent() {
    Car car = Car.ofState(true, false);
    RemoteController controller = new RemoteController(car);

    Command unlockDoorCommand = new LockUnlockDoorCommand(car);
    controller.dispatch(unlockDoorCommand);

    assertThat(car)
        .hasFieldOrPropertyWithValue("areDoorLocked", false)
        .hasFieldOrPropertyWithValue("areDoorOpen", false);
  }

  @Test
  public void shouldCloseTheDoor_whenCloseCommandIsSent() {
    Car car = Car.ofState(false, true);
    RemoteController controller = new RemoteController(car);

    Command lockDoorCommand = new CloseOpenDoorCommand(car);
    controller.dispatch(lockDoorCommand);

    assertThat(car)
        .hasFieldOrPropertyWithValue("areDoorLocked", false)
        .hasFieldOrPropertyWithValue("areDoorOpen", false);
  }

  @Test
  public void shouldOpenTheDoor_whenOpenCommandIsSent() {
    Car car = Car.ofState(false, false);
    RemoteController controller = new RemoteController(car);

    Command unlockDoorCommand = new CloseOpenDoorCommand(car);
    controller.dispatch(unlockDoorCommand);

    assertThat(car)
        .hasFieldOrPropertyWithValue("areDoorLocked", false)
        .hasFieldOrPropertyWithValue("areDoorOpen", true);
  }
}
