package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

public class ManagerHandler extends Handler {

  public ManagerHandler(Handler successor) {
    super(successor);
  }

  @Override
  public RequestResult handleRequest(Request request) {
    return request.getAmount() < 500
        ? RequestResult.of(request.getAmount(), "Manager")
        : successor.handleRequest(request);
  }
}
