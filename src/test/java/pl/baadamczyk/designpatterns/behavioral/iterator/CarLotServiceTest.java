package pl.baadamczyk.designpatterns.behavioral.iterator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarLotServiceTest {

    private CarLotService service;

    @BeforeEach
    public void setUp() {
        service = new CarLotService();
    }

    @Test
    public void shouldReturnAllCars() {

        assertThat(service.getAllCars())
                .hasSize(6)
                .contains("OFFER_ID: 500|BRAND: TOYOTA|MODEL: RAV4|YEAR: 2001|PRICE: 17700,00|STATE: AVAILABLE");
    }

    @Test
    public void shouldRemoveAllSoldCars() {

        service.removeSoldCars();

        assertThat(service.getAllCars())
                .hasSize(4)
                .contains("OFFER_ID: 500|BRAND: TOYOTA|MODEL: RAV4|YEAR: 2001|PRICE: 17700,00|STATE: AVAILABLE")
                .doesNotContain("OFFER_ID: 422|BRAND: TOYOTA|MODEL: RAV4|YEAR: 2006|PRICE: 2500,00|STATE: SOLD");
    }

    @Test
    public void shouldRemoveSoldCar() {
        service.removeOffer(422);

        assertThat(service.getAllCars())
                .hasSize(5)
                .doesNotContain("OFFER_ID: 422|BRAND: TOYOTA|MODEL: RAV4|YEAR: 2006|PRICE: 2500,00|STATE: SOLD");
    }

    @Test
    public void shouldThrowAnException_whenTryingToRemoveAvailableCar() {

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> service.removeOffer(500))
                .withMessage("Cannot remove AVAILABLE car!");
    }
}