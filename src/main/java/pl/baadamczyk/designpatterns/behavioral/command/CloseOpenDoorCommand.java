package pl.baadamczyk.designpatterns.behavioral.command;

public class CloseOpenDoorCommand implements Command {

  private final Car car;

  public CloseOpenDoorCommand(Car car) {
    this.car = car;
  }

  @Override
  public void execute() {
    car.closeOpenTheDoor();
  }

  @Override
  public void rollback() {
    car.closeOpenTheDoor();
  }
}
