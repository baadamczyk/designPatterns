package pl.baadamczyk.designpatterns.creational.abstractFactory;

public class PeugeotCarFactory extends CarFactory {
    @Override
    public Car getCarInstance(Type type) {
        switch(type) {
            case SUV:
                return Car.of("SUV", "3008");
            case COUPE:
                return Car.of("COUPE", "407");
            case HATCHBACK:
                return Car.of("HATCHBACK", "206");
            default:
                throw new IllegalArgumentException();
        }
    }
}
