package javaa.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory implements Subject {
    private final List<Transaction> transactions;
    private final List<Observer> observers;

    public TransactionHistory() {
        transactions = new ArrayList<>();
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(transaction);
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void printTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
