package pl.baadamczyk.designpatterns.structural.adapter;

import lombok.Value;

@Value(staticConstructor = "of")
public class SystemProperty {

    public String name;
    public String value;
}
