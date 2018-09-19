package pl.baadamczyk.designpatterns.structural.composite;

import java.util.Iterator;
import java.util.List;

public class NodeItem extends MenuItem {

  public NodeItem(String label) {
    super(label, null);
  }

  public List<MenuItem> getChildren() {
    return menuComponents;
  }

  public void addChild(String name, String url) {
    LeafItem childItem = new LeafItem(name, url);
    menuComponents.add(childItem);
  }

  public void remove(String name) {
    Iterator itemsIterator = menuComponents.iterator();

    while (itemsIterator.hasNext()) {
      MenuItem item = (MenuItem) itemsIterator.next();
      if (name.equals(item.getLabel())) {
        itemsIterator.remove();
      }
    }
  }
}
