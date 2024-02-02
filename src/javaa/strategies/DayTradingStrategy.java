package javaa.strategies;

import javaa.stock.Stock;

public class DayTradingStrategy implements TradingStrategy {
    @Override
    public void execute(Stock stock, int quantity) {
        // Example logic for day trading
        double recentLow = stock.getRecentLowPrice(); // Hypothetical method to get recent low price
        double currentPrice = stock.getPrice();

        if (currentPrice > recentLow && currentPrice < (recentLow * 1.05)) {
            System.out.println("Buying " + quantity + " of " + stock.getTickerSymbol() + " for day trading at " + currentPrice);
            // Execute buy order
        } else {
            System.out.println("Conditions not suitable for day trading " + stock.getTickerSymbol());
            // Hold or sell logic
        }
    }
}
