public class LongTermInvestingStrategy implements TradingStrategy {
    @Override
    public void execute(Stock stock, int quantity) {
        // Example logic for long-term investing
        double fiveYearGrowthRate = stock.getFiveYearGrowthRate(); // Hypothetical method to get 5-year growth rate
        double currentPEratio = stock.getCurrentPERatio(); // Hypothetical method to get current P/E ratio

        if (fiveYearGrowthRate > 0.10 && currentPEratio < 25) {
            System.out.println("Buying " + quantity + " of " + stock.getTickerSymbol() + " for long-term investing at " + stock.getPrice());
            // Execute buy order
        } else {
            System.out.println("Conditions not suitable for long-term investing in " + stock.getTickerSymbol());
            // Hold or look for other stocks
        }
    }
}
