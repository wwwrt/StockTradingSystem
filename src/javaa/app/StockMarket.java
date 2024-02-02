package javaa.app;

import javaa.stock.Stock;
import javaa.stock.StockList;
import javaa.transactions.Transaction;
import javaa.users.User;
import javaa.users.UserFactory;

import java.util.List;

public class StockMarket {
    private static StockMarket instance;

    private StockMarket() {
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }


    public void start() {
        // Setup
        StockList stockList = StockList.getInstance();
        UserFactory userFactory = new UserFactory();

        // Crearea și adăugarea stocurilor
        setupStocks(stockList);

        // Crearea utilizatorilor
        User user1 = userFactory.createUser("regular", "User1");
        User user2 = userFactory.createUser("regular", "User2");
        User user3 = userFactory.createUser("regular", "User3");
        User admin1 = userFactory.createUser("admin", "Admin1");
        User admin2 = userFactory.createUser("admin", "Admin2");

        // Adăugare fonduri și efectuare tranzacții
        setupUsersAndTransactions(user1, user2, user3, admin1, admin2);

        // Afișare informații utilizatori
        displayUserInformation(user1);
        displayUserInformation(user2);
        displayUserInformation(user3);
        displayUserInformation(admin1);
        displayUserInformation(admin2);
    }


    private void setupStocks(StockList stockList) {
        stockList.addStock(new Stock("Company A", "A", 100.0, 50, 0.08, 20.0));
        stockList.addStock(new Stock("Company B", "B", 150.0, 30, 0.05, 25.0));
        stockList.addStock(new Stock("Company C", "C", 75.0, 20, 0.10, 15.0));
        stockList.addStock(new Stock("Company D", "D", 120.0, 40, 0.06, 30.0));
    }

    private void setupUsersAndTransactions(User... users) {
        StockList stockList = StockList.getInstance();
        int funds = 10000;
        for (User user : users) {
            user.getPortfolio().addFunds(funds);
            funds += 5000; // Incrementare fonduri pentru diversitate
            // Alocarea stocurilor utilizatorilor, asigurându-ne că fiecare cumpără stocuri diferite
            List<Stock> allStocks = stockList.getAllStocks();
            for (int i = 0; i < allStocks.size() && i < users.length; i++) {
                // Asigurăm că indexul stocului nu depășește dimensiunea listei de stocuri
                Stock stock = allStocks.get(i);
                user.buyStock(stock, (int) (Math.random() * 5) + 1); // Cantități aleatorii între 1 și 5
            }
        }
    }


    private void displayUserInformation(User user) {
        System.out.println("User: " + user.getUsername());
        System.out.println("Portfolio:");
        displayPortfolio(user.getPortfolio().getAllStocks());
        System.out.println("Transaction History:");
        displayTransactionHistory(user.getTransactionHistory().getTransactions());
        System.out.println();
    }

    private void displayPortfolio(List<Stock> stocks) {
        for (Stock stock : stocks) {
            System.out.println("Ticker Symbol: " + stock.getTickerSymbol());
            System.out.println("Name: " + stock.getName());
            System.out.println("Quantity: " + stock.getQuantity());
            System.out.println("Current Price: $" + stock.getPrice());
            System.out.println();
        }
    }

    private void displayTransactionHistory(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println("Stock: " + transaction.getStock().getName());
            System.out.println("Quantity: " + transaction.getQuantity());
            System.out.println("Price: $" + transaction.getPrice());
            System.out.println("Date: " + transaction.getDate());
            System.out.println();
        }
    }
}

// si aici am folosit Singleton pentru că am avut nevoie de control centralizat