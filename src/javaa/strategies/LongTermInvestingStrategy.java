package javaa.strategies;

import javaa.stock.Stock;

public class LongTermInvestingStrategy implements TradingStrategy {
    @Override
    public void execute(Stock stock, int quantity) {
        double fiveYearGrowthRate = stock.getFiveYearGrowthRate();
        double currentPEratio = stock.getCurrentPERatio();

        if (fiveYearGrowthRate > 0.10 && currentPEratio < 25) {
            System.out.println("Buying " + quantity + " of " + stock.getTickerSymbol() + " for long-term investing at " + stock.getPrice());
        } else {
            System.out.println("Conditions not suitable for long-term investing in " + stock.getTickerSymbol());
        }
    }
}
