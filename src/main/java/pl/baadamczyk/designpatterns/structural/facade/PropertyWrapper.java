package pl.baadamczyk.designpatterns.structural.facade;

import lombok.Value;

@Value(staticConstructor = "of")
public class PropertyWrapper {

    private String key;
    private String value;
    private int interval;
    private String owner;
}
