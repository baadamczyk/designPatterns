package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import java.util.List;

public class InternetPartsOrder extends PartsOrderTemplate {

  public InternetPartsOrder(List<OrderItem> orderItems) {
    super(orderItems);
  }

  @Override
  public double selectItems(List<OrderItem> orderItems) {
    return orderItems
        .stream()
        .mapToDouble(o -> applyInternetPurchaseDiscount(o.getPrice() * o.getQuantity()))
        .sum();
  }

  //This method will apply 2% discount for internet purchase
  private double applyInternetPurchaseDiscount(double price) {
    return price * 0.98;
  }

  @Override
  public double doPackage() {
    return 5.00;
  }

  @Override
  public double applyDeliveryFee() {
    return 53.20;
  }

  @Override
  public double applyOtherFees() {
    return 0;
  }
}
