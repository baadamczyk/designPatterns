package pl.baadamczyk.designpatterns.behavioral.interpreter;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

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

  public static TokenWrapper tokenize(String context) {
      TokenWrapper wrapper = new TokenWrapper();

    System.out.println("CONTEXT: " + context);

    Stream<String> aggregateSplitStream = Arrays.asList(context.split("\\?")).stream();

    System.out.println("AggregateSplit");
    aggregateSplitStream.forEach(System.out::println);

      wrapper.addAggregate("aggr1");
      wrapper.addCommand("cmd1");
      wrapper.addEvent("evt1");


      return wrapper;
  }
}
