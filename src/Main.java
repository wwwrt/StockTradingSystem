import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup
        StockList stockList = StockList.getInstance();
        UserFactory userFactory = new UserFactory();

        // Create 4 stocks
        Stock stock1 = new Stock("Company A", "A", 100.0, 50, 0.08, 20.0);
        Stock stock2 = new Stock("Company B", "B", 150.0, 30, 0.05, 25.0);
        Stock stock3 = new Stock("Company C", "C", 75.0, 20, 0.10, 15.0);
        Stock stock4 = new Stock("Company D", "D", 120.0, 40, 0.06, 30.0);

        // Add stocks to the stock list
        stockList.addStock(stock1);
        stockList.addStock(stock2);
        stockList.addStock(stock3);
        stockList.addStock(stock4);

        // Create 5 users
        User user1 = userFactory.createUser("regular", "User1");
        User user2 = userFactory.createUser("regular", "User2");
        User user3 = userFactory.createUser("regular", "User3");
        User admin1 = userFactory.createUser("admin", "Admin1");
        User admin2 = userFactory.createUser("admin", "Admin2");

        // Adăugarea fondurilor în portofolii
        user1.getPortfolio().addFunds(10000); // Adăugând 10.000 unități monetare în portofoliul lui User1
        user2.getPortfolio().addFunds(15000); // Similar pentru User2
        user3.getPortfolio().addFunds(20000); // Adăugând 20.000 unități monetare în portofoliul lui User3
        admin1.getPortfolio().addFunds(30000); // Adăugând 30.000 unități monetare în portofoliul lui Admin1
        admin2.getPortfolio().addFunds(25000); // Adăugând 25.000 unități monetare în portofoliul lui Admin2

        // Efectuarea tranzacțiilor
        user1.buyStock(stock1, 10); // User1 cumpără 10 acțiuni din Company A
        user2.buyStock(stock2, 5);  // User2 cumpără 5 acțiuni din Company B
        user3.buyStock(stock3, 7);  // User3 cumpără 7 acțiuni din Company C
        admin1.buyStock(stock4, 4); // Admin1 cumpără 4 acțiuni din Company D
        admin2.buyStock(stock1, 15);

        // Display user portfolios and transaction history
        displayUserInformation(user1);
        displayUserInformation(user2);
        displayUserInformation(user3);
        displayUserInformation(admin1);
        displayUserInformation(admin2);
    }

    private static void displayUserInformation(User user) {
        System.out.println("User: " + user.getUsername());
        System.out.println("Portfolio:");
        displayPortfolio((List<Stock>) user.getPortfolio().getAllStocks()); // Presupunând că există o metodă getAllStocks
        System.out.println("Transaction History:");
        displayTransactionHistory(user.getTransactionHistory().getTransactions());
        System.out.println();
    }

    private static void displayPortfolio(List<Stock> stocks) {
        for (Stock stock : stocks) {
            System.out.println("Ticker Symbol: " + stock.getTickerSymbol());
            System.out.println("Name: " + stock.getName());
            System.out.println("Quantity: " + stock.getQuantity());
            System.out.println("Current Price: $" + stock.getPrice());
            System.out.println();
        }
    }

    private static void displayTransactionHistory(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (transaction.getStock() == null) {
                System.out.println("Found a transaction with null stock.");
                continue; // daca istoricul tranzactiilor e gol
            }
            System.out.println("Stock: " + transaction.getStock().getName());
            System.out.println("Quantity: " + transaction.getQuantity());
            System.out.println("Price: $" + transaction.getPrice());
            System.out.println("Date: " + transaction.getDate());
            System.out.println();
        }
    }
}
