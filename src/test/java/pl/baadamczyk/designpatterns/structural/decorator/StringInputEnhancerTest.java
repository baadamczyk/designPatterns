package pl.baadamczyk.designpatterns.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringInputEnhancerTest {

  @Test
  public void shouldDelimitInput() {
    DataWrapper inputData =
        new DataWrapper("BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS");
    DataWrapper expectedOutput =
        new DataWrapper("BOKKA - WHAT A DAY | HEALTH - TEARS | NIGEL STANFORD - CYMATICS");
    InputDelimiter delimiter = new InputDelimiter(inputData);

    assertThat(delimiter.getDataString()).isNotNull().isEqualTo(expectedOutput.getDataString());
  }

  @Test
  public void shouldFormatInput() {
    DataWrapper inputData =
        new DataWrapper("BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS");
    DataWrapper expectedOutput =
        new DataWrapper("**** BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS ****");

    InputFormatter formatter = new InputFormatter(inputData);

    assertThat(formatter.getDataString()).isNotNull().isEqualTo(expectedOutput.getDataString());
  }

  @Test
  public void shouldChainDecorators() {
    DataWrapper inputData =
        new DataWrapper("BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS");
    DataWrapper expectedOutput =
        new DataWrapper(
            "**** BOKKA - WHAT A DAY | HEALTH - TEARS | NIGEL STANFORD - CYMATICS ****");

    InputDelimiter delimiter = new InputDelimiter(inputData);
    InputFormatter formatter = new InputFormatter(delimiter);

    assertThat(formatter.getDataString()).isNotNull().isEqualTo(expectedOutput.getDataString());
  }

  @Test
  public void shouldChainDecorators_givenReversedDecoratorOrger() {
    DataWrapper inputData =
        new DataWrapper("BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS");
    DataWrapper expectedOutput =
        new DataWrapper(
            "**** BOKKA - WHAT A DAY | HEALTH - TEARS | NIGEL STANFORD - CYMATICS ****");

    InputFormatter formatter = new InputFormatter(inputData);
    InputDelimiter delimiter = new InputDelimiter(formatter);

    assertThat(delimiter.getDataString()).isNotNull().isEqualTo(expectedOutput.getDataString());
  }
}
