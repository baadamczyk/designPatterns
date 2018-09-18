package pl.baadamczyk.designpatterns.creational.abstractFactory;

// This is out abstract factory. It will return contrete factory, basing on given parameter
public abstract class CarFactory {

    // method reutns type of CarFactroy, so every factory that extends CarFactory could be returned
    public static CarFactory getInstance(Brand brand) {
        switch(brand) {
            case AUDI:
                return new AudiCarFactory();
            case SUZUKI:
                return new SuzukiCarFactory();
            case ALFA_ROMEO:
                return new AlfaRomeoCarFactory();
            case TOYOTA:
                return new ToyotaCarFactory();
            case PEUGEOT:
                return new PeugeotCarFactory();
            default:
                throw new IllegalArgumentException("There is no factory for given brand");
        }
    }

    // There is also abstract method specified so every concrete factory will work in a same way
    public abstract Car getCarInstance(Type type);
}
