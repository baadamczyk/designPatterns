package pl.baadamczyk.designpatterns.behavioral.interpreter;

public class JoinedExpression implements Expression {

  private Expression expression1;
  private Expression expression2;
  private Expression expression3;
  private Expression expression4;

  public JoinedExpression(
      Expression expression1,
      Expression expression2,
      Expression expression3,
      Expression expression4) {

    this.expression1 = expression1;
    this.expression2 = expression2;
    this.expression3 = expression3;
    this.expression4 = expression4;
  }

  @Override
  public boolean parse(String input) {
    return expression1.parse(input)
        && expression2.parse(input)
        && expression3.parse(input)
        && expression4.parse(input);
  }
}
