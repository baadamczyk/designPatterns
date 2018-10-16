package pl.baadamczyk.designpatterns.behavioral.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferCaretakerTest {

  private TransferCaretaker caretaker;
  private BankAccount account;

  @BeforeEach
  public void setUp() {
    caretaker = new TransferCaretaker();
  }

  @Test
  public void shouldRevertBankTransfer() {
    account = new BankAccount(10000);

    caretaker.save(account);
    account.transfer(-7000);
    caretaker.revert(account);

    assertThat(account.getState()).isEqualTo(10000);
  }
}
