package pl.baadamczyk.designpatterns.behavioral.mediator;

public class TurnOffAllLightsCommand implements Command {

  private SmartHomeDriver mediator;

  public TurnOffAllLightsCommand(SmartHomeDriver mediator) {
    this.mediator = mediator;
  }

  @Override
  public void execute() {
    mediator.turnOffTheLights();
  }
}
