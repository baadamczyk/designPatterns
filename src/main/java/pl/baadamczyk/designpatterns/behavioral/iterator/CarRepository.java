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

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < carList.size() && carList.get(currentIndex) != null;
            }

            @Override
            public Car next() {
                return carList.get(currentIndex++);
            }

            @Override
            public void remove() {
                --currentIndex;

                if(State.SOLD.equals(carList.get(currentIndex).getState())){
                    carList.remove(carList.get(currentIndex));
                    currentIndex++;
                }
                else {
                    currentIndex++;
                    throw new UnsupportedOperationException("Cannot remove AVAILABLE car!");
                }
            }
        };
    }
}
