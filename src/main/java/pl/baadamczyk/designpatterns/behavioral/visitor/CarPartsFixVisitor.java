package pl.baadamczyk.designpatterns.behavioral.visitor;

public class CarPartsFixVisitor implements PartsVisitor {
    @Override
    public void visit(Part part) {
        part.fix();
    }
}
