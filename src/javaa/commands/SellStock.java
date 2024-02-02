package javaa.commands;

import javaa.transactions.Transaction;
import javaa.portfolio.Order;
import javaa.stock.Stock;
import javaa.users.User;

import java.time.LocalDateTime;

public class SellStock implements Order {
    private final Stock stock;
    private final int quantity;
    private final User user;

    public SellStock(User user, Stock stock, int quantity) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        // Check if the user owns the stock and has enough quantity
        if (user.getPortfolio().hasStock(stock.getTickerSymbol(), quantity) &&
                user.getPortfolio().getStockQuantity(stock.getTickerSymbol()) >= quantity) {

            // Update the user's portfolio
            user.getPortfolio().removeStockQuantity(stock.getTickerSymbol(), quantity);

            // Record the transaction
            Transaction transaction = new Transaction(stock, quantity, stock.getPrice(), LocalDateTime.now(), "SELL");
            user.getTransactionHistory().addTransaction(transaction);
        } else {
            // Handle the case where the user does not own enough stock
            System.out.println("Insufficient stock in portfolio.");
        }
    }
}
