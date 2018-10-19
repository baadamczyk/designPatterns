package pl.baadamczyk.designpatterns.behavioral.visitor;

public abstract class Part {

  public void diagnose() {};

  public void fix() {};

  public void replace() {};

  public final void accept(PartsVisitor visitor) {
    visitor.visit(this);
  };
}
