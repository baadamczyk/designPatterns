package pl.baadamczyk.designpatterns.structural.decorator;

/*
    Both decorated component (DataWrapper) and Augmentor (abstraction for decorator) implements this interface.
    Thanks to that we are able to get data from DataWrapper and ENRICH that data using Augmentors (decorators).
*/

public interface Augmentable {

    String getDataString();
}
