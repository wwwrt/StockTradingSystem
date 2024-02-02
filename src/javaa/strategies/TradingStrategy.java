package javaa.strategies;

import javaa.stock.Stock;

public interface TradingStrategy {
    void execute(Stock stock, int quantity);
}
