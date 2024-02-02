package javaa.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private final List<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    // Metoda pentru a afișa istoricul tranzacțiilor
    public void printTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

