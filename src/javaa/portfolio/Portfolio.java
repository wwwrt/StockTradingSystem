package javaa.portfolio;

import javaa.stock.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Portfolio {
    private Map<String, Stock> stocks;
    private double availableFunds; // Adăugarea unui câmp pentru fondurile disponibile

    public Portfolio() {
        this.stocks = new HashMap<>();
        this.availableFunds = 0; // Inițializarea fondurilor cu 0
    }

    // Metodă pentru a adăuga fonduri
    public void addFunds(double amount) {
        if (amount > 0) {
            availableFunds += amount;
        }
    }

    // Metodă pentru a deduce fonduri
    public void deductFunds(double amount) {
        if (amount > 0 && amount <= availableFunds) {
            availableFunds -= amount;
        }
    }

    public double getAvailableFunds() {
        return availableFunds;
    }
    public void addStock(Stock stock, int quantity) {
        if (stocks.containsKey(stock.getTickerSymbol())) {
            Stock existingStock = stocks.get(stock.getTickerSymbol());
            existingStock.setQuantity(existingStock.getQuantity() + quantity);
        } else {
            stock.setQuantity(quantity);
            stocks.put(stock.getTickerSymbol(), stock);
        }
    }

    public void removeStockQuantity(String tickerSymbol, int quantityToRemove) {
        if (stocks.containsKey(tickerSymbol)) {
            Stock stock = stocks.get(tickerSymbol);
            int currentQuantity = stock.getQuantity();
            if (quantityToRemove >= currentQuantity) {
                stocks.remove(tickerSymbol);
            } else {
                stock.setQuantity(currentQuantity - quantityToRemove);
            }
        }
    }

    public List<Stock> getAllStocks() {
        return new ArrayList<>(stocks.values());
    }

    public int getStockQuantity(String tickerSymbol) {
        return stocks.containsKey(tickerSymbol) ? stocks.get(tickerSymbol).getQuantity() : 0;
    }

    public boolean hasStock(String tickerSymbol, int quantity) {
        return stocks.containsKey(tickerSymbol);
    }

    public Stock getStock(String tickerSymbol) {
        return stocks.get(tickerSymbol);
    }

}
