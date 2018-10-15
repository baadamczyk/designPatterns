package pl.baadamczyk.designpatterns.behavioral.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class TransferCaretakerTest {

    private TransferCaretaker caretaker;
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        caretaker = new TransferCaretaker();
    }

    @Test
    public void shouldRevertBankTransfer() {
        account = BankAccount.ofState(10000);
    }
}
