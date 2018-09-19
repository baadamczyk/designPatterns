package pl.baadamczyk.designpatterns.structural.composite;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompositeExampleTest {

  @Test
  public void shouldReturnChildItems() {
    NodeItem nodeItem = new NodeItem("PRODUCTS");
    nodeItem.addChild("INDUSTRY", "[INDUSTRY_URL]");
    nodeItem.addChild("CONSUMERS", "[CONSUMERS_URL]");
    List<MenuItem> childList = nodeItem.getChildren();

    assertThat(nodeItem).extracting(i -> i.getLabel()).isEqualTo("PRODUCTS");
    assertThat(childList).hasSize(2);
  }

  @Test
  public void shouldAddChild() {
    NodeItem nodeItem = new NodeItem("PRODUCTS");
    int initialChildrenCount = nodeItem.getChildren().size();

    nodeItem.addChild("INDUSTRY", "[INDUSTRY_URL]");
    int finalChildrenCount = nodeItem.getChildren().size();

    assertThat(finalChildrenCount).isGreaterThan(initialChildrenCount).isEqualTo(1);
  }

  @Test
  public void shouldRemoveChild() {
    NodeItem nodeItem = new NodeItem("PRODUCTS");
    nodeItem.addChild("INDUSTRY", "[INDUSTRY_URL]");
    nodeItem.addChild("CONSUMERS", "[CONSUMERS_URL]");
    int initialChildrenCount = nodeItem.getChildren().size();

    nodeItem.remove("INDUSTRY");
    int finalChildrenCount = nodeItem.getChildren().size();

    assertThat(finalChildrenCount).isLessThan(initialChildrenCount).isEqualTo(1);
  }
}
