package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

public class CeoHandler extends Handler {

  public CeoHandler(Handler successor) {
    super(successor);
  }

  @Override
  public RequestResult handleRequest(Request request) {
    return request.getAmount() >= 1000
        ? RequestResult.of(request.getAmount(), "CEO")
        : successor.handleRequest(request);
  }
}
