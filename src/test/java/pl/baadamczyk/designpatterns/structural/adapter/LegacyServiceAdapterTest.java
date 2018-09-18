package pl.baadamczyk.designpatterns.structural.adapter;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegacyServiceAdapterTest {

  public Gson gson;

  @BeforeEach
  public void setUp() {
    gson = new Gson();
  }

  @Test
  public void shouldGetValidObject_whenPropertyIsSet() {
    SystemProperty actualProperty;
    String propertyJson = gson.toJson(SystemProperty.of("testProperty", "originalValue"));
    SystemProperty propertyWrapper = SystemProperty.of("testProperty", "changedValue");

    LegacyService.setProperty(propertyJson);
    actualProperty = LegacyService.getProperty("testProperty");

    NewService.setProperty(propertyWrapper);
    actualProperty = LegacyService.getProperty("testProperty");

    assertThat(actualProperty).isNotNull().isEqualTo(propertyWrapper);
  }
}
