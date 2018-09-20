package pl.baadamczyk.designpatterns.structural.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
    This factory is managing the lifecycle of items. It checks if item already exists, and if no - creates it
*/
public class StoreItemFactory {

  private static Map<String, Item> inventoryMap = new ConcurrentHashMap<>();

  public static Item getItem(String itemCode) {
    if (!inventoryMap.containsKey(itemCode)) {
      inventoryMap.put(itemCode, Item.of(itemCode));
    }

    return inventoryMap.get(itemCode);
  }
}
