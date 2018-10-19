package pl.baadamczyk.designpatterns.behavioral.visitor;

public class ShockAbsorber extends Part {

  @Override
  public void diagnose() {
    this.isDiagnosed = true;
  }

  @Override
  public void fix() {
    this.isFixed = true;
  }

  @Override
  public void replace() {
    this.isReplaced = true;
  }
}
