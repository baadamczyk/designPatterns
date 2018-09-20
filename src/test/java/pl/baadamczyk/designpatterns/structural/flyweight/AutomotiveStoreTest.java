package pl.baadamczyk.designpatterns.structural.flyweight;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutomotiveStoreTest {

  @Test
  public void shouldReturnTheSameInstance_whenRequestingMultipleTimes() {

    Item firstItem = StoreItemFactory.getItem("015-22-1");
    Item secondItem = StoreItemFactory.getItem("015-22-1");
    Item thirdItem = StoreItemFactory.getItem("015-22-1");
    Item fourthItem = StoreItemFactory.getItem("078-44-8");
    Item fifthItem = StoreItemFactory.getItem("078-44-8");

    assertThat(firstItem)
        .isEqualTo(secondItem)
        .isEqualTo(thirdItem)
        .isNotEqualTo(fourthItem)
        .isNotEqualTo(fifthItem);

    assertThat(fourthItem).isEqualTo(fifthItem);
  }
}
