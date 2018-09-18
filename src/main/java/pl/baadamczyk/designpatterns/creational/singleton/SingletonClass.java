package pl.baadamczyk.designpatterns.creational.singleton;

public class SingletonClass {

    //volatile keyword is needed if we want to preserve multithread safety
    private static volatile SingletonClass instance;

    //Constructor is private so we cannot created this object using 'new' keyword
    private SingletonClass() {
        if(instance != null) throw new UnsupportedOperationException("Creation by reflection is not supported");
    }

    //If instance is not already created - create new one
    //Return statically stored instance
    public static SingletonClass getInstance() {
        if(instance == null) instance = new SingletonClass();
        return instance;
    }
}
