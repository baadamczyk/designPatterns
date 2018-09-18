package pl.baadamczyk.designpatterns.creational.abstractFactory;

public class AlfaRomeoCarFactory extends CarFactory {
    @Override
    public Car getCarInstance(Type type) {
        switch(type) {
            case SUV:
                return Car.of("SUV", "Stelvio");
            case COUPE:
                return Car.of("COUPE", "GT");
            case HATCHBACK:
                return Car.of("HATCHBACK", "MiTo");
            default:
                throw new IllegalArgumentException();
        }
    }
}
