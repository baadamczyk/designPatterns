package pl.baadamczyk.designpatterns.behavioral.iterator;

import com.google.common.collect.Lists;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Log
public class CarLotService {

    private static volatile CarLotService carLotService;

    private CarRepository repository;
    private Iterator<Car> iterator;

    public CarLotService() {

        this.repository = new CarRepository();

        repository.addVehicles(Lists.newArrayList(
                new Car(500, Brand.TOYOTA, "RAV4", 2001, 17700, State.AVAILABLE),
                new Car(1030, Brand.TOYOTA, "RAV4", 2000, 15700, State.AVAILABLE),
                new Car(422, Brand.TOYOTA, "RAV4", 2006, 2500, State.SOLD),
                new Car(771, Brand.SUZUKI, "Grand Vitara", 2008, 28000, State.AVAILABLE),
                new Car(2301, Brand.ALFA_ROMEO, "GT", 2008, 22000, State.SOLD),
                new Car(1077, Brand.PEUGEOT, "2006", 2004, 1100, State.AVAILABLE)
        ));
    }

    // Iterator usage
    public List<String> getAllCars() {
        List<String> carListing = new ArrayList<>();
        iterator = repository.iterator();

        while(iterator.hasNext()) {
            carListing.add(iterator.next().toString());
        }

        return carListing;
    }


    public void removeOffer(Integer offerId) {
        iterator = repository.iterator();

        while(iterator.hasNext()) {
            if(offerId.equals(iterator.next().getOfferId())) {
                iterator.remove();
            }
        }
    }

    public void removeSoldCars() {
        iterator = repository.iterator();


        while(iterator.hasNext()) {
            Car car = iterator.next();

            if(State.SOLD.equals(car.getState())) {
                iterator.remove();
            }
        }
    }
}
