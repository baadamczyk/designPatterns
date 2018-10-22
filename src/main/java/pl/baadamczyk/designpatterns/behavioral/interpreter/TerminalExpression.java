package pl.baadamczyk.designpatterns.behavioral.interpreter;

import java.util.List;

public class TerminalExpression implements Expression {

  private String token;

  public TerminalExpression(String token) {
    this.token = token;
  }

  @Override
  public boolean parse(String controlStructure) {
    List<String> tokens = SyntaxUtility.tokenize(controlStructure);

    return tokens.contains(token);
  }
}
