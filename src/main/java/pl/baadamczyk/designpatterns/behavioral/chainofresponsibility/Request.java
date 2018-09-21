package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

import lombok.Value;

@Value(staticConstructor = "of")
public class Request {

  private float amount;
}
