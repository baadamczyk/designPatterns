package pl.baadamczyk.designpatterns.creational.abstractFactory;

import lombok.Value;

//Lombok's static constructor enables us to use 'Object.of' instead of 'new Object'
@Value(staticConstructor = "of")
public class Car {

    private String type;
    private String modelName;
}
