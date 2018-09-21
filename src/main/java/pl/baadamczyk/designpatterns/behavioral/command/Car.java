package pl.baadamczyk.designpatterns.behavioral.command;

public class Car {

  private boolean areDoorLocked;
  private boolean areDoorOpen;

  private Car(boolean areDoorLocked, boolean areDoorOpen) {
    this.areDoorLocked = areDoorLocked;
    this.areDoorOpen = areDoorOpen;
  }

  public static Car ofState(boolean areDoorLocked, boolean areDoorOpen) {
    return new Car(areDoorLocked, areDoorOpen);
  }

  public void lockUnlockTheDoor() {
    if (areDoorLocked) {
      unlock();
      areDoorLocked = false;
    } else {
      lock();
      areDoorLocked = true;
    }
  }

  public void closeOpenTheDoor() {
    if (areDoorOpen) {
      close();
      areDoorOpen = false;
    } else {
      open();
      areDoorOpen = true;
    }
  }

  public boolean areDoorLocked() {
    return areDoorLocked;
  }

  public boolean areDoorOpen() {
    return areDoorOpen;
  }

  private void lock() {
    System.out.println("Doors locked");
  }

  private void unlock() {
    System.out.println("Doors unlocked");
  }

  private void open() {
    System.out.println("Doors open");
  }

  private void close() {
    System.out.println("Doors closed");
  }
}
