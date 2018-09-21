package pl.baadamczyk.designpatterns.structural.facade;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FacadeTest {

  @Test
  public void shouldManageProperties_givenLegacyAPI() {
    String key = "propertyKey";

    LegacyAPI.setKey(key);
    LegacyAPI.setValue("propertyValue");
    LegacyAPI.setInterval(1000);
    LegacyAPI.setOwner("Admin");

    assertThat(LegacyAPI.getValue(key)).isEqualTo("propertyValue");
    assertThat(LegacyAPI.getInterval(key)).isEqualTo(1000);
    assertThat(LegacyAPI.getOwner(key)).isEqualTo("Admin");
  }

  @Test
  public void shouldManageProperties_givenFacade() {
    String key = "propertyKey";
    PropertyWrapper inputWrapper = PropertyWrapper.of(key, "propertyValue", 1000, "Admin");
    ModernAPIFacade.setProperties(inputWrapper);

    PropertyWrapper outputWrapper = ModernAPIFacade.getProperties(key);

    assertThat(outputWrapper)
        .hasFieldOrPropertyWithValue("value", inputWrapper.getValue())
        .hasFieldOrPropertyWithValue("interval", inputWrapper.getInterval())
        .hasFieldOrPropertyWithValue("owner", inputWrapper.getOwner());
  }

  @Test
  public void shouldGetProperies_whenLegacyApiIsInvoked_givenSetByFacade() {
    String key = "propertyKey";
    PropertyWrapper inputWrapper = PropertyWrapper.of(key, "propertyValue", 1000, "Admin");
    ModernAPIFacade.setProperties(inputWrapper);

    assertThat(LegacyAPI.getValue(key)).isEqualTo(inputWrapper.getValue());
    assertThat(LegacyAPI.getInterval(key)).isEqualTo(inputWrapper.getInterval());
    assertThat(LegacyAPI.getOwner(key)).isEqualTo(inputWrapper.getOwner());
  }

  @Test
  public void shouldGetProperties_whenFacadeIsInvoked_givenSetByLegacyAPI() {
    String key = "propertyKey";

    LegacyAPI.setKey(key);
    LegacyAPI.setValue("propertyValue");
    LegacyAPI.setInterval(1000);
    LegacyAPI.setOwner("Admin");

    PropertyWrapper outputWrapper = ModernAPIFacade.getProperties(key);

    assertThat(outputWrapper)
        .hasFieldOrPropertyWithValue("value", "propertyValue")
        .hasFieldOrPropertyWithValue("interval", 1000)
        .hasFieldOrPropertyWithValue("owner", "Admin");
  }
}
