package pl.baadamczyk.designpatterns.behavioral.visitor;

public class CarPartsDiagnosisVisitor implements PartsVisitor {
    @Override
    public void visit(Part part) {
        part.diagnose();
    }
}
