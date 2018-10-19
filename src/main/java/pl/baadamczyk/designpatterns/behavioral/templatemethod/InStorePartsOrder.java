package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import java.util.List;

public class InStorePartsOrder extends PartsOrderTemplate {

  public InStorePartsOrder(List<OrderItem> orderItems) {
    super(orderItems);
  }

  @Override
  public double selectItems(List<OrderItem> orderItems) {
    return orderItems.stream().mapToDouble(o -> o.getPrice() * o.getQuantity()).sum();
  }

  @Override
  public double doPackage() {
    return 2.00;
  }

  @Override
  public double applyDeliveryFee() {
    return 0;
  }

  @Override
  public double applyOtherFees() {
    return 0;
  }
}
