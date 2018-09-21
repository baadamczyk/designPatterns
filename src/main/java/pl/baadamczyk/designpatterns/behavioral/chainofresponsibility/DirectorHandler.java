package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

public class DirectorHandler extends Handler {

  public DirectorHandler(Handler successor) {
    super(successor);
  }

  @Override
  public RequestResult handleRequest(Request request) {
    return request.getAmount() >= 500 && request.getAmount() < 1000
        ? RequestResult.of(request.getAmount(), "Director")
        : successor.handleRequest(request);
  }
}
