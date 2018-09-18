package pl.baadamczyk.designpatterns.creational.abstractFactory;

public class AudiCarFactory extends CarFactory {
    @Override
    public Car getCarInstance(Type type) {
        switch(type) {
            case SUV:
                return Car.of("SUV", "Q7");
            case COUPE:
                return Car.of("COUPE", "S5");
            case HATCHBACK:
                return Car.of("HATCHBACK", "A3");
            default:
                throw new IllegalArgumentException();
        }
    }
}
