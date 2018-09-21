package pl.baadamczyk.designpatterns.behavioral.command;

public class LockUnlockDoorCommand implements Command {

    private final Car car;

    public LockUnlockDoorCommand(Car car) {
        this.car = car;
    }

    @Override
    public void execute() {
        car.lockUnlockTheDoor();
    }

    @Override
    public void rollback() {
        car.lockUnlockTheDoor();
    }
}
