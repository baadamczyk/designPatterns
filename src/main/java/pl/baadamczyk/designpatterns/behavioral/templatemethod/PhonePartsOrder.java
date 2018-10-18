package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import java.util.List;

public class PhonePartsOrder extends PartsOrderTemplate {

  public PhonePartsOrder(List<OrderItem> orderItems) {
    super(orderItems);
  }

  @Override
  public double selectItems(List<OrderItem> orderItems) {
    return orderItems.stream().mapToDouble(o -> o.getPrice() * o.getQuantity()).sum();
  }

  @Override
  public double doPackage() {
    return 5.00;
  }

  @Override
  public double applyDeliveryFee() {
    return 53.20;
  }

  //Apply operational fee
  @Override
  public double applyOtherFees() {
    return 15;
  }
}
