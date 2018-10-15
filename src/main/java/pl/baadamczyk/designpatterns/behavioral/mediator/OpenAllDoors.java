package pl.baadamczyk.designpatterns.behavioral.mediator;

public class OpenAllDoors implements Command {

  private SmartHomeDriver mediator;

  public OpenAllDoors(SmartHomeDriver mediator) {
    this.mediator = mediator;
  }

  @Override
  public void execute() {
    mediator.openAllDoors();
  }
}
