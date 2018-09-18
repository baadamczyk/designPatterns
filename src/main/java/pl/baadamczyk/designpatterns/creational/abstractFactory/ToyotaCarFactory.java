package pl.baadamczyk.designpatterns.creational.abstractFactory;

public class ToyotaCarFactory extends CarFactory {
    @Override
    public Car getCarInstance(Type type) {
        switch(type) {
            case SUV:
                return Car.of("SUV", "RAV4");
            case COUPE:
                return Car.of("COUPE", "Celica");
            case HATCHBACK:
                return Car.of("HATCHBACK", "Yaris");
            default:
                throw new IllegalArgumentException();
        }
    }
}
