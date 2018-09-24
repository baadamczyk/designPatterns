package pl.baadamczyk.designpatterns.behavioral.command;

/*
  Invoker
*/
public class RemoteController {

  private Car car;

  public RemoteController(Car car) {
    this.car = car;
  }

  public void dispatch(Command command) {
    command.execute();
  }
}
