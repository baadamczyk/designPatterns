package pl.baadamczyk.designpatterns.creational.prototype;

import lombok.Value;

@Value(staticConstructor = "of")
public class Vehicle implements Cloneable {

    private String type;
    private int numberOfWheels;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
