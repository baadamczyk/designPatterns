package pl.baadamczyk.designpatterns.behavioral.visitor;

public abstract class Part {

  public boolean isDiagnosed;
  public boolean isFixed;
  public boolean isReplaced;

  public void diagnose() {};

  public void fix() {};

  public void replace() {};

  public void accept(PartsVisitor visitor) {
    visitor.visit(this);
  };
}
