package pl.baadamczyk.designpatterns.behavioral.observer;

import java.util.ArrayDeque;
import java.util.Deque;

public class WateringSystemDriver extends Subject{

    private Deque<SystemStatus> statusHistory = new ArrayDeque<>();

    @Override
    public void setState(SystemStatus status) {
        statusHistory.add(status);
        this.sendStatusMessage();
    }

    @Override
    public SystemStatus getState() {
        return statusHistory.getLast();
    }
}
