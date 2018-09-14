package pl.baadamczyk.designpatterns.creational.factory;

import lombok.Value;

@Value(staticConstructor = "of")
public class Car {

    private String type;
    private String modelName;
}
