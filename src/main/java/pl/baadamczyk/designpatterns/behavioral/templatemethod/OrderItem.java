package pl.baadamczyk.designpatterns.behavioral.templatemethod;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class OrderItem {

    private String name;
    private int quantity;
    private double price;
}
