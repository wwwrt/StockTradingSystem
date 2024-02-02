package javaa.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockList {
    private static StockList instance;
    private final List<Stock> stocks;

    private StockList() {
        stocks = new ArrayList<>();
    }

    public static StockList getInstance() {
        if (instance == null) {
            instance = new StockList();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public Optional<Stock> findStockBySymbol(String tickerSymbol) {
        return stocks.stream()
                .filter(stock -> stock.getTickerSymbol().equals(tickerSymbol))
                .findFirst();
    }

    public Optional<Stock> findStockByName(String name) {
        return stocks.stream()
                .filter(stock -> stock.getName().equals(name))
                .findFirst();
    }

    public void updateStockPrice(String tickerSymbol, double newPrice) {
        findStockBySymbol(tickerSymbol).ifPresent(stock -> stock.setPrice(newPrice));
    }

    public void updateStockQuantity(String tickerSymbol, int newQuantity) {
        findStockBySymbol(tickerSymbol).ifPresent(stock -> stock.setQuantity(newQuantity));
    }

    public List<Stock> getAllStocks() {
        return new ArrayList<>(stocks); // Returning a copy to preserve encapsulation
    }

    public boolean isStockAvailable(String tickerSymbol) {
        return findStockBySymbol(tickerSymbol).isPresent();
    }
}
