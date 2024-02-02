package javaa.stock;

import java.util.Objects;

public class Stock {
    private String name;
    private String tickerSymbol;
    private double price;
    private int quantity;
    private double recentLowPrice;
    private double fiveYearGrowthRate;
    private double currentPERatio;

    public Stock(String name, String tickerSymbol, double price, int quantity, double fiveYearGrowthRate, double currentPERatio) {
        this.name = name;
        this.tickerSymbol = tickerSymbol;
        this.price = price;
        this.quantity = quantity;
        this.recentLowPrice = price;
        this.fiveYearGrowthRate = fiveYearGrowthRate;
        this.currentPERatio = currentPERatio;
    }

    // nume
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // simbol bursier
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    // preț
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // cantitate
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // prețul minim recent
    public double getRecentLowPrice() {
        return recentLowPrice;
    }

    public void setRecentLowPrice(double recentLowPrice) {
        this.recentLowPrice = recentLowPrice;
    }

    // rata de creștere pe cinci ani
    public double getFiveYearGrowthRate() {
        return fiveYearGrowthRate;
    }

    public void setFiveYearGrowthRate(double fiveYearGrowthRate) {
        this.fiveYearGrowthRate = fiveYearGrowthRate;
    }

    // raportul preț/profit (P/E)
    public double getCurrentPERatio() {
        return currentPERatio;
    }

    public void setCurrentPERatio(double currentPERatio) {
        this.currentPERatio = currentPERatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock stock)) return false;
        return Double.compare(stock.price, price) == 0 &&
                quantity == stock.quantity &&
                Double.compare(stock.recentLowPrice, recentLowPrice) == 0 &&
                Double.compare(stock.fiveYearGrowthRate, fiveYearGrowthRate) == 0 &&
                Double.compare(stock.currentPERatio, currentPERatio) == 0 &&
                Objects.equals(name, stock.name) &&
                Objects.equals(tickerSymbol, stock.tickerSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tickerSymbol, price, quantity, recentLowPrice, fiveYearGrowthRate, currentPERatio);
    }


    @Override
    public String toString() {
        return "java.Stock{" +
                "name='" + name + '\'' +
                ", tickerSymbol='" + tickerSymbol + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", recentLowPrice=" + recentLowPrice +
                '}';
    }
}
