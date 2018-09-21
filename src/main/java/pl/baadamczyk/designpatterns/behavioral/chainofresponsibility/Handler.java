package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

public abstract class Handler {

  protected Handler successor;

  public Handler(Handler successor) {
    this.successor = successor;
  }

  public abstract RequestResult handleRequest(Request request);
}
