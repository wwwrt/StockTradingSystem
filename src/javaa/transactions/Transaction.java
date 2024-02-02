package javaa.transactions;

import javaa.stock.Stock;

import java.time.LocalDateTime;

public class Transaction {
    private Stock stock;
    private int quantity;
    private double price;
    private LocalDateTime date;
    private String transactionType; // BUY or SELL

    // Constructor
    public Transaction(Stock stock, int quantity, double price, LocalDateTime date, String transactionType) {
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.transactionType = transactionType;
    }


    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // transaction details
    @Override
    public String toString() {
        return "java.Transaction{" +
                "stock=" + stock +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + date +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
