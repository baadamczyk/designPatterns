package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PartsOrderTemplateTest {

    private OrderTemplate order;
    private List<OrderItem> orderedItems;

    @BeforeEach
    public void setUp() {
        orderedItems = Arrays.asList(
                new OrderItem("Brake pads", 1, 60.00),
                new OrderItem("Brake discs", 2, 135.20),
                new OrderItem("Rear shock absorbers", 2, 115.00),
                new OrderItem("Accessories belt", 3, 102.15),
                new OrderItem("Water pump", 1, 96.00)
        );
    }

    @Test
    @Disabled("Not implemented")
    private void shouldSumUpCosts_whenUsingInStoreOrder() {
        order = InStoreOrder(orderedItems);

        //TODO: bag: 2zl
    }

    @Test
    @Disabled("Not implemented")
    private void shouldSumUpCosts_whenUsingWebOrder() {
        //TODO: packaging: 5zl, delivery: 53.20
    }

    @Test
    @Disabled("Not implemented")
    private void shouldSumUpCosts_whenUsingPhoneOrder() {
        //TODO: operationalfee: 15zl, packaging: 5zl, delivery: 53.20
    }
}
