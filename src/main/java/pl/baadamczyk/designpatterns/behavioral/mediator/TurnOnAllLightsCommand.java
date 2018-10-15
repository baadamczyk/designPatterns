package pl.baadamczyk.designpatterns.behavioral.mediator;

public class TurnOnAllLightsCommand implements Command {

  private SmartHomeDriver mediator;

  public TurnOnAllLightsCommand(SmartHomeDriver mediator) {
    this.mediator = mediator;
  }

  @Override
  public void execute() {
    mediator.turnOnTheLights();
  }
}
