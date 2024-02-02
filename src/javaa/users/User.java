package javaa.users;

import javaa.portfolio.Portfolio;
import javaa.stock.Stock;
import javaa.transactions.Transaction;
import javaa.transactions.TransactionHistory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private Portfolio portfolio;
    private TransactionHistory transactionHistory;

    // Constructor
    public User(String username) {
        this.username = username;
        this.portfolio = new Portfolio();
        this.transactionHistory = new TransactionHistory();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    // java.User-specific methods
    public void buyStock(Stock stock, int quantity) {
        if (stock == null || quantity <= 0) {
            System.out.println("Invalid buy request.");
            return;
        }

        double totalCost = stock.getPrice() * quantity;

        // Check if user has enough funds
        if (totalCost <= portfolio.getAvailableFunds()) {
            // Deduct funds from the user's portfolio
            portfolio.deductFunds(totalCost);

            // Update the stock in the user's portfolio
            portfolio.addStock(stock, quantity);

            // Record the transaction in the history
            Transaction buyTransaction = new Transaction(stock, quantity, stock.getPrice(), LocalDateTime.now(), "BUY");
            transactionHistory.addTransaction(buyTransaction);


            System.out.println("Buy successful.");
        } else {
            System.out.println("Insufficient funds to buy.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (stock == null || quantity <= 0) {
            System.out.println("Invalid sell request.");
            return;
        }

        // Check if user has the stock in the portfolio
        if (portfolio.hasStock(stock.getTickerSymbol(), quantity)) {
            // Add funds to the user's portfolio
            double earnings = stock.getPrice() * quantity;
            portfolio.addFunds(earnings);

            // Update the stock in the user's portfolio
            portfolio.removeStockQuantity(stock.getTickerSymbol(), quantity);

            // Record the transaction in the history
            Transaction sellTransaction = new Transaction(stock, quantity, stock.getPrice(), LocalDateTime.now(), "SELL");
            transactionHistory.addTransaction(sellTransaction);

            System.out.println("Sell successful.");
        } else {
            System.out.println("Insufficient stocks to sell.");
        }
    }

    public void viewPortfolio() {
        Map<String, Stock> stocks = (Map<String, Stock>) portfolio.getAllStocks();
        if (stocks.isEmpty()) {
            System.out.println("java.Portfolio is empty.");
        } else {
            System.out.println("java.Portfolio:");
            for (Stock stock : stocks.values()) {
                System.out.println("Ticker Symbol: " + stock.getTickerSymbol());
                System.out.println("Name: " + stock.getName());
                System.out.println("Quantity: " + stock.getQuantity());
                System.out.println("Current Price: $" + stock.getPrice());
                System.out.println();
            }
        }
    }

    public List<Transaction> viewTransactionHistory() {
        return transactionHistory.getTransactions();
    }
}
