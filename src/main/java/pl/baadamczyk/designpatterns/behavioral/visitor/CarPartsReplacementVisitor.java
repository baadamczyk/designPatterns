package pl.baadamczyk.designpatterns.behavioral.visitor;

public class CarPartsReplacementVisitor implements PartsVisitor {
    @Override
    public void visit(Part part) {
        part.replace();
    }
}
