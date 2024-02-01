import java.time.LocalDateTime;

public class BuyStock implements Order {
    private Stock stock;
    private int quantity;
    private User user;

    public BuyStock(User user, Stock stock, int quantity) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        // Check if the stock is available in sufficient quantity
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
