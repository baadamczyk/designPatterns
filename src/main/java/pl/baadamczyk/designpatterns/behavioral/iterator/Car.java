package pl.baadamczyk.designpatterns.behavioral.iterator;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Car {

    private int offerId;
    private Brand brand;
    private String model;
    private int year;
    private float price;
    private State state;

    @Override
    public String toString() {
        String formatTemplate = "OFFER_ID: %d|BRAND: %s|MODEL: %s|YEAR: %d|PRICE: %.2f|STATE: %s";
        return String.format(formatTemplate, offerId, brand.toString(), model, year, price, state.toString());
    }
}
