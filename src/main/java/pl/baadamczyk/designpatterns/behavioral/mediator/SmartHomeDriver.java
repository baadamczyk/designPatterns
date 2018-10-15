package pl.baadamczyk.designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

// This is our Mediator
public class SmartHomeDriver {

  private static List<Door> doorRegistry = new ArrayList<>();
  private static List<Light> lightsRegistry = new ArrayList<>();

  public void registerDoors(List<Door> doorList) {
    doorRegistry.addAll(doorList);
  }

  public void registerLights(List<Light> lightList) {
    lightsRegistry.addAll(lightList);
  }

  public void openAllDoors() {
    doorRegistry.stream().forEach(d -> d.setClosed(false));
  }

  public void closeAllDoors() {
    doorRegistry.stream().forEach(d -> d.setClosed(true));
  }

  public void turnOnTheLights() {
    lightsRegistry.stream().forEach(l -> l.setOn(true));
  }

  public void turnOffTheLights() {
    lightsRegistry.stream().forEach(l -> l.setOn(false));
  }

  public void openTheHome() {
    openAllDoors();
    turnOnTheLights();
  }

  public void closeTheHome() {
    closeAllDoors();
    turnOffTheLights();
  }
}
