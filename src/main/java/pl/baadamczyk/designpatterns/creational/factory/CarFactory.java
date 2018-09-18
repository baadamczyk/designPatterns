package pl.baadamczyk.designpatterns.creational.factory;

//This simple factory returns different car type for different given param
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
