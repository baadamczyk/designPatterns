package pl.baadamczyk.designpatterns.behavioral.chainofresponsibility;

import lombok.Value;

@Value(staticConstructor = "of")
public class RequestResult {

  private float amount;
  private String approver;
}
