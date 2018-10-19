package pl.baadamczyk.designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class PartsHandler extends Part{

  private List<Part> partList;

  public PartsHandler() {
    this.partList = new ArrayList<>();
  }

  public void addPart(Part part) {
      partList.add(part);
  }

  public void accept(CarPartsDiagnosisVisitor visitor) {
      partList.stream().forEach(p -> p.accept(visitor));
  }
}
