package pl.baadamczyk.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarRepository implements Iterable<Car> {

    private List<Car> carList;

    public CarRepository() {
        this.carList = new ArrayList<>();
    }

    public void addVehicles(List<Car> cars) {
        carList.addAll(cars);
    }

    //Implementing iterator for this repository
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex < carList.size() - 1;
            }

            @Override
            public Car next() {
                return carList.get(++currentIndex);
            }

            @Override
            public void remove() {

                if(State.SOLD.equals(carList.get(currentIndex).getState())){
                    carList.remove(carList.get(currentIndex));
                }
                else {
                    throw new UnsupportedOperationException("Cannot remove AVAILABLE car!");
                }
            }
        };
    }
}
