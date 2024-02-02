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
            // Update the stock quantity
            stock.setQuantity(stock.getQuantity() - quantity);

            // Update the user's portfolio
            user.getPortfolio().addStock(stock, quantity);

            // Record the transaction
            Transaction transaction = new Transaction(stock, quantity, stock.getPrice(), LocalDateTime.now(), "BUY");
            user.getTransactionHistory().addTransaction(transaction);
        } else {
            // Handle the case where stock is not available in sufficient quantity
            System.out.println("Insufficient stock available.");
        }
    }
}
