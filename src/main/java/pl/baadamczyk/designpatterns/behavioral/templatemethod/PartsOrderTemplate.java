package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import java.math.BigDecimal;
import java.util.List;

public abstract class PartsOrderTemplate {

  public double orderSum;
  public List<OrderItem> orderItems;

  public PartsOrderTemplate(List<OrderItem> orderItems) {
    this.orderItems = orderItems;
    orderSum = 0.00;
  }

  public abstract double selectItems(List<OrderItem> orderItems);

  public abstract double doPackage();

  public abstract double applyDeliveryFee();

  public abstract double applyOtherFees();

  // This method is final to prevent overriding. That's the Template Method - our algorithm
  public final double processOrder() {
    orderSum += selectItems(orderItems);
    orderSum += doPackage();
    orderSum += applyDeliveryFee();
    orderSum += applyOtherFees();

    return BigDecimal.valueOf(orderSum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
  }
}
