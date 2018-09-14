package pl.baadamczyk.designpatterns.creational.factory;

public class CarFactory {

  public static Car getInstance(String type) {

    switch (type) {
      case "SUV":
        return Car.of("SUV", "Stelvio");
      case "COUPE":
        return Car.of("COUPE", "GT");
      default:
        throw new IllegalArgumentException("Car type not supported");
    }
  }
}
