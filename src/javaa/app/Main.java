package javaa.app;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = StockMarket.getInstance();
        stockMarket.start();
    }
}
