package pl.baadamczyk.designpatterns.behavioral.mediator;

public class CloseAllDoorsCommand implements Command {

  private SmartHomeDriver mediator;

  public CloseAllDoorsCommand(SmartHomeDriver mediator) {
    this.mediator = mediator;
  }

  @Override
  public void execute() {
    mediator.closeAllDoors();
  }
}
