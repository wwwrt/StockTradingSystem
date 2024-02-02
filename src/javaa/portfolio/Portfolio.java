package javaa.portfolio;

import javaa.stock.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Portfolio {
    private Map<String, Stock> stocks;
    private double availableFunds;

    public Portfolio() {
        this.stocks = new HashMap<>();
        this.availableFunds = 0;
    }

    // adăugare fonduri
    public void addFunds(double amount) {
        if (amount > 0) {
            availableFunds += amount;
        }
    }
    // deducere fonduri
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

// am folosit puțin composite - prin gestionarea unei colecții de obiecte Stock într-o structură de tip Map,
// clasa Portfolio tratează individual fiecare stoc și agregatele de stocuri în mod uniform.
// chair daca nu in cel mai tradițional mod, am folosit strategy, deoarece consider că
// logica de gestionare a stocurilor și a fondurilor ar putea fi văzută ca o strategie
// pentru administrarea resurselor financiare ale unui utilizator. Știu că pentru a fi legit
// ar trebui să permită schimbarea comportamentului de gestionare a portofoliului în timpul execuției
// prin injecția de strategii diferite, dar totuși..
// Și intr-un sens larg, state, deoarece portfolio gestionează starea internă a portofoliului, inclusiv
// fondurile disponibile și stocurile deținute, iar schimbările de stare sunt efectuate prin metodele publice.