package pl.baadamczyk.designpatterns.behavioral.interpreter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.baadamczyk.designpatterns.behavioral.iterpreter.Expression;
import pl.baadamczyk.designpatterns.behavioral.iterpreter.InterpretationResult;
import pl.baadamczyk.designpatterns.behavioral.iterpreter.SyntaxUtility;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class InterpreterTests {

  private Expression definedInterpreter;

  @BeforeEach
  public void setUp() {
    definedInterpreter = SyntaxUtility.buildInterpreterSyntax();
  }

  @Test
  public void shouldFindCompleteStructure_givenCompleteContext() {
    String context = "SET ResumeAggregate WITH_COMMANDS CreateResumeCommand WITH_EVENTS ResumeCreatedEvent";

    List<String> expectedAggregates = Lists.newArrayList("ResumeAggregate");
    Map<String, List<String>> expectedCommands =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("CreateResumeCommand"))
            .build();
    Map<String, List<String>> expectedEvents =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("ResumeCreatedEvent"))
            .build();

    InterpretationResult result = definedInterpreter.interpret(context);

    assertThat(result)
        .hasFieldOrPropertyWithValue("aggregates", expectedAggregates)
        .hasFieldOrPropertyWithValue("commands", expectedCommands)
        .hasFieldOrPropertyWithValue("events", expectedEvents);
    assertThat(result.getErrors()).isEmpty();
  }

  @Test
  public void shouldFindMultipleCommands_givenCompleteContext() {
    String context =
        "SET ResumeAggregate WITH_COMMANDS CreateResumeCommand ArchiveResumeCommand WITH_EVENTS ResumeCreatedEvent";

    List<String> expectedAggregates = Lists.newArrayList("ResumeAggregate");
    Map<String, List<String>> expectedCommands =
        ImmutableMap.<String, List<String>>builder()
            .put(
                "ResumeAggregate",
                Lists.newArrayList("CreateResumeCommand", "ArchiveResumeCommand"))
            .build();
    Map<String, List<String>> expectedEvents =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("ResumeCreatedEvent"))
            .build();

    InterpretationResult result = definedInterpreter.interpret(context);

    assertThat(result)
        .hasFieldOrPropertyWithValue("aggregates", expectedAggregates)
        .hasFieldOrPropertyWithValue("commands", expectedCommands)
        .hasFieldOrPropertyWithValue("events", expectedEvents);
    assertThat(result.getErrors()).isEmpty();
  }

  @Test
  public void shouldFindMultipleEvents_givenCompleteContext() {
    String context =
        "SET ResumeAggregate WITH_COMMANDS CreateResumeCommand WITH_EVENTS ResumeCreatedEvent ResumeArchivedEvent";

    List<String> expectedAggregates = Lists.newArrayList("ResumeAggregate");
    Map<String, List<String>> expectedCommands =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("CreateResumeCommand"))
            .build();
    Map<String, List<String>> expectedEvents =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("ResumeCreatedEvent", "ResumeArchivedEvent"))
            .build();

    InterpretationResult result = definedInterpreter.interpret(context);

    assertThat(result)
        .hasFieldOrPropertyWithValue("aggregates", expectedAggregates)
        .hasFieldOrPropertyWithValue("commands", expectedCommands)
        .hasFieldOrPropertyWithValue("events", expectedEvents);
    assertThat(result.getErrors()).isEmpty();
  }

  @Test
  public void shouldFindMultipleStructures_givenCompleteContext() {
    String context =
        "SET ResumeAggregate WITH_COMMANDS CreateResumeCommand WITH_EVENTS ResumeCreatedEvent " +
                "SET EmployeeAggregate WITH_COMMANDS CreateEmployeeCommand WITH_EVENTS EmployeeCreatedEvent";

    List<String> expectedAggregates = Lists.newArrayList("ResumeAggregate", "EmployeeAggregate");
    Map<String, List<String>> expectedCommands =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("CreateResumeCommand"))
            .put("EmployeeAggregate", Lists.newArrayList("CreateEmployeeCommand"))
            .build();
    Map<String, List<String>> expectedEvents =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("ResumeCreatedEvent"))
            .put("EmployeeAggregate", Lists.newArrayList("EmployeeCreatedEvent"))
            .build();

    InterpretationResult result = definedInterpreter.interpret(context);

    assertThat(result)
        .hasFieldOrPropertyWithValue("aggregates", expectedAggregates)
        .hasFieldOrPropertyWithValue("commands", expectedCommands)
        .hasFieldOrPropertyWithValue("events", expectedEvents);
    assertThat(result.getErrors()).isEmpty();
  }

  @Test
  public void shouldReportCommandWithoutAggregate_givenContextWithCommandAndEventOnly() {
    String context = "WITH_COMMANDS CreateResumeCommand";

    List<String> expectedAggregates = Lists.newArrayList();
    Map<String, List<String>> expectedCommands =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList("CreateResumeCommand"))
            .build();
    Map<String, List<String>> expectedEvents =
        ImmutableMap.<String, List<String>>builder()
            .put("ResumeAggregate", Lists.newArrayList())
            .build();

    InterpretationResult result = definedInterpreter.interpret(context);

    assertThat(result)
        .hasFieldOrPropertyWithValue("aggregates", expectedAggregates)
        .hasFieldOrPropertyWithValue("commands", expectedCommands)
        .hasFieldOrPropertyWithValue("events", expectedEvents);
    assertThat(result.getErrors()).contains("NO AGGREGATE at 0");
  }

  @Test
  public void dummy() {
    //    String context = "? ResumeAggregate >> CreateResumeCommand << ResumeCreatedEvent";
    String context =
            "SET ResumeAggregate WITH_COMMANDS CreateResumeCommand WITH_EVENTS ResumeCreatedEvent " +
                    "SET EmployeeAggregate WITH_COMMANDS CreateEmployeeCommand WITH_EVENTS EmployeeCreatedEvent";

    SyntaxUtility.parse(context);
  }
}
