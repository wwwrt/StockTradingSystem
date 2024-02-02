package javaa.stock;

import java.util.Objects;

public class Stock {
    private String name;
    private String tickerSymbol;
    private double price;
    private int quantity;
    private double recentLowPrice;
    private double fiveYearGrowthRate;  // Rata de creștere pe cinci ani
    private double currentPERatio;      // Raportul preț/profit curent (P/E)

    // Constructor
    public Stock(String name, String tickerSymbol, double price, int quantity, double fiveYearGrowthRate, double currentPERatio) {
        this.name = name;
        this.tickerSymbol = tickerSymbol;
        this.price = price;
        this.quantity = quantity;
        this.recentLowPrice = price;
        this.fiveYearGrowthRate = fiveYearGrowthRate;
        this.currentPERatio = currentPERatio;
    }

    // Getter și Setter pentru nume
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter și Setter pentru simbolul bursier
    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    // Getter și Setter pentru preț
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter și Setter pentru cantitate
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter și Setter pentru prețul minim recent
    public double getRecentLowPrice() {
        return recentLowPrice;
    }

    public void setRecentLowPrice(double recentLowPrice) {
        this.recentLowPrice = recentLowPrice;
    }

    // Getter și setter pentru rata de creștere pe cinci ani
    public double getFiveYearGrowthRate() {
        return fiveYearGrowthRate;
    }

    public void setFiveYearGrowthRate(double fiveYearGrowthRate) {
        this.fiveYearGrowthRate = fiveYearGrowthRate;
    }

    // Getter și setter pentru raportul preț/profit (P/E)
    public double getCurrentPERatio() {
        return currentPERatio;
    }

    public void setCurrentPERatio(double currentPERatio) {
        this.currentPERatio = currentPERatio;
    }

    // Metodele equals, hashCode și toString
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
