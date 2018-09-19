package pl.baadamczyk.designpatterns.structural.decorator;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StringInputEnhancerTest {

  @Test
  public void shouldDelimitInput() {
    String inputString = "BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS";
    String expectedOutputString = "BOKKA - WHAT A DAY | HEALTH - TEARS | NIGEL STANFORD - CYMATICS";
    InputDelimiter delimiter = new InputDelimiter(inputString);

    assertThat(delimiter.print()).isNotNull().isEqualTo(expectedOutputString);
  }

  @Test
  @Disabled("Not implemented")
  public void shouldFormatInput_givenDelimitedString() {
    String inputString = "BOKKA:WHAT A DAY|HEALTH:TEARS|NIGEL STANFORD:CYMATICS";
    String expectedOutputString =
        "Artist: BOKKA Title: WHAT A DAY | Artist: HEALTH Title: TEARS | Artist: NIGEL STANFORD Title: CYMATICS";

    InputDelimiter delimiter = new InputDelimiter(inputString);
    InputFormatter formatter = new InputFormatter(delimiter);

    assertThat(formatter.print()).isNotNull().isEqualTo(expectedOutputString);
  }
}
