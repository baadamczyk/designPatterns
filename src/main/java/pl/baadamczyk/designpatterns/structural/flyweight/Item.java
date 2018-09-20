package pl.baadamczyk.designpatterns.structural.flyweight;

/*
    This class is immutable!
*/

import lombok.Value;

@Value(staticConstructor = "of")
public class Item {

  private final String code;
}
