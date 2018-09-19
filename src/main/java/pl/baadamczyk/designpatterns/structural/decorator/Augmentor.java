package pl.baadamczyk.designpatterns.structural.decorator;

/*
    This is an abstraction for concrete augmentors (decorators).
    Thanks to the fact that abstract classes can also implement interfaces, we can pass
    to the decorator both DataWrapper AND another concrete augmentor (decorator).
*/

public abstract class Augmentor implements Augmentable {

    protected Augmentable componentInstance;

    public Augmentor(Augmentable component) {
        this.componentInstance = component;
    }
}
