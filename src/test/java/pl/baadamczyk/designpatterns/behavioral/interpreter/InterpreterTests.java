package pl.baadamczyk.designpatterns.behavioral.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InterpreterTests {

  private Expression intepreter;

  @BeforeEach
  public void setUp() {
    intepreter = buildInterpreter();
  }

  private Expression buildInterpreter() {
    Expression pwrIgnitionExpression = new TerminalExpression("PWR");
    Expression accIgnitionExpression = new TerminalExpression("ACC");
    Expression fpmpIgnitionExpression = new TerminalExpression("FPMP");
    Expression ignIgnitionExpression = new TerminalExpression("IGN");

    Expression requiredTogglesExpression =
        new JoinedExpression(
            pwrIgnitionExpression,
            accIgnitionExpression,
            fpmpIgnitionExpression,
            ignIgnitionExpression);

    return requiredTogglesExpression;
  }

  @Test
  public void shouldStartIfAllRequiredInstructionsArePresent() {
    String controlStructure = "PWR ACC FPMP IGN";

    boolean isAbleToStart = intepreter.parse(controlStructure);

    assertThat(isAbleToStart).isTrue();
  }

  @Test
  public void shouldNotStartIfNotAllRequiredInstructionsArePresent() {
    String controlStructure = "ACC FPMP IGN";

    boolean isAbleToStart = intepreter.parse(controlStructure);

    assertThat(isAbleToStart).isFalse();
  }
}
