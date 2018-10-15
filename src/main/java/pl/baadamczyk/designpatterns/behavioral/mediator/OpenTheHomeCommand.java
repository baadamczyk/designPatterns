package pl.baadamczyk.designpatterns.behavioral.mediator;

public class OpenTheHomeCommand implements Command {

  private SmartHomeDriver mediataor;

  public OpenTheHomeCommand(SmartHomeDriver mediator) {
    this.mediataor = mediator;
  }

  @Override
  public void execute() {
    mediataor.openTheHome();
  }
}
