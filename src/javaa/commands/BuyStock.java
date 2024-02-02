package javaa.commands;

import javaa.transactions.Transaction;
import javaa.portfolio.Order;
import javaa.stock.Stock;
import javaa.users.User;

import java.time.LocalDateTime;

public class BuyStock implements Order {
    private final Stock stock;
    private final int quantity;
    private final User user;

    public BuyStock(User user, Stock stock, int quantity) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute() {

        if (stock.getQuantity() >= quantity) {
            stock.setQuantity(stock.getQuantity() - quantity);

            user.getPortfolio().addStock(stock, quantity);

            Transaction transaction = new Transaction(stock, quantity, stock.getPrice(), LocalDateTime.now(), "BUY");
            user.getTransactionHistory().addTransaction(transaction);
        } else {
            System.out.println("Insufficient stock available.");
        }
    }
}
