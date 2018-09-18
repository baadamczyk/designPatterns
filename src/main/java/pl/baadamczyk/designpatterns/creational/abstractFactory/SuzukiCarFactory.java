package pl.baadamczyk.designpatterns.creational.abstractFactory;

public class SuzukiCarFactory extends CarFactory {
    @Override
    public Car getCarInstance(Type type) {
        switch(type) {
            case HATCHBACK:
                return Car.of("HATCHBACK", "Swift");
            case SUV:
                return Car.of("SUV", "Grand Vitara");
            default:
                throw new IllegalArgumentException();
        }
    }
}
