package javaa.transactions;

public class TransactionObserver implements Observer {
    private final String name;

    public TransactionObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Transaction transaction) {
        System.out.println("Observer " + name + " notified of new transaction: " + transaction);
    }
}
