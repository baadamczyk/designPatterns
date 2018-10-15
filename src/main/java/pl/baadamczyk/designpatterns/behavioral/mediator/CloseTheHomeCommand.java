package pl.baadamczyk.designpatterns.behavioral.mediator;

public class CloseTheHomeCommand implements Command {

  private SmartHomeDriver mediator;

  public CloseTheHomeCommand(SmartHomeDriver mediator) {
    this.mediator = mediator;
  }

  @Override
  public void execute() {
    mediator.closeTheHome();
  }
}
