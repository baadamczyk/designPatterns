package pl.baadamczyk.designpatterns.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BankAccount {

  @Getter private float state;

  public void transfer(float amount) {
    this.state += amount;
  }

    public BankAccountMemento save() {
      return BankAccountMemento.of(state);
    }

    public void revert(BankAccountMemento memento) {
      this.state = memento.getState();
    }
}
