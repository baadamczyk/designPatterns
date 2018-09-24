package pl.baadamczyk.designpatterns.behavioral.command;

/*
    This is an interface for all further commands to implement
*/
public interface Command {

  void execute();

  void rollback();
}
