package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PartsOrderTemplateTest {

  private PartsOrderTemplate order;
  private List<OrderItem> orderedItems;

  @BeforeEach
  public void setUp() {
    orderedItems =
        Arrays.asList(
            new OrderItem("Brake pads", 1, 60.00),
            new OrderItem("Brake discs", 2, 135.20),
            new OrderItem("Rear shock absorbers", 2, 115.00),
            new OrderItem("Accessories belt", 3, 102.15),
            new OrderItem("Water pump", 1, 96.00));
  }

  @Test
  public void shouldSumUpCosts_whenUsingInStoreOrder() {
    order = new InStorePartsOrder(orderedItems);
    double orderSum = order.processOrder();

    assertThat(orderSum).isEqualTo(964.85);
  }

  @Test
  public void shouldSumUpCosts_whenUsingWebOrder() {
    order = new InternetPartsOrder(orderedItems);
    double orderSum = order.processOrder();

    assertThat(orderSum).isEqualTo(1001.79);
  }

  @Test
  public void shouldSumUpCosts_whenUsingPhoneOrder() {
    order = new PhonePartsOrder(orderedItems);
    double orderSum = order.processOrder();

    assertThat(orderSum).isEqualTo(1036.05);
  }
}
