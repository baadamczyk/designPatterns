package pl.baadamczyk.designpatterns.creational.singleton;

public class SingletonClass {

    private static volatile SingletonClass instance;

    private SingletonClass() {
        if(instance != null) throw new UnsupportedOperationException("Creation by reflection is not supported");
    }

    public static SingletonClass getInstance() {
        if(instance == null) instance = new SingletonClass();
        return instance;
    }
}
