package pl.baadamczyk.designpatterns.behavioral.iterpreter;

import com.google.common.base.Splitter;

import java.util.*;

public class SyntaxUtility {

  public static Expression buildInterpreterSyntax() {
    Expression enumStartTerminakExpression = new EnumerationStartExpression();
    Expression aggregateTerminalExpression = new AggregateDistinguishExpression();
    Expression commandTerminalExpression = new CommandDistinguishExpression();
    Expression eventTerminalExpression = new EventDistinguishExpression();

    return new Expression() {
      @Override
      public InterpretationResult interpret(String context) {
        return null;
      }
    };
  }

  public static InterpretationResult parse(String context) {

    System.out.println("CONTEXT: " + context);

    Iterator<String> iterator = Splitter.on(" ").trimResults().split(context).iterator();

    String key = "";
    List<String> aggregates = new ArrayList<>();
    Map<String, List<String>> commandMap = new HashMap<>();
    Map<String, List<String>> eventMap = new HashMap<>();
    List<String> commands = new ArrayList<>();
    List<String> events = new ArrayList<>();

    while (iterator.hasNext()) {
      String currentToken = iterator.next();
      System.out.println("Current token: " + currentToken);

      if (currentToken.equals(LangToken.SET.toString())) {
        System.out.println("AGGREGATE: " + currentToken);
        commandMap.put(key, commands);
        eventMap.put(key, events);

        key = currentToken;
        aggregates.add(keyg);

        commands.clear();
        events.clear();
      }

      if (currentToken.equals(LangToken.WITH_COMMANDS.toString())) { //TODO: change enum to use tostring internally
        System.out.println("COMMAND: " + currentToken);
        commands.add(currentToken);
      }

      if(currentToken.equals(LangToken.WITH_EVENTS.toString())) {
          events.add(currentToken);
      }
    }

    System.out.println("RESULTS: ");
    System.out.println("AGGREGATES: " + aggregates.toString());
    System.out.println("COMMANDS: " + commandMap.toString());
    System.out.println("EVENTS: " + eventMap.toString());

    return null;
  }
}
