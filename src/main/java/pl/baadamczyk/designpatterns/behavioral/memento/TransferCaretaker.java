package pl.baadamczyk.designpatterns.behavioral.memento;

import java.util.Stack;

public class TransferCaretaker {

    private Stack<BankAccountMemento> accountHistory = new Stack<>();

    public void save(BankAccount account) {
        accountHistory.push(account.save());
    }

    public void revert(BankAccount account) {
        account.revert(accountHistory.pop());
    }
}
