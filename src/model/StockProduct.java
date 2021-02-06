package model;

import java.time.LocalDate;
import java.util.Date;

public class StockProduct {


    int amount;
    LocalDate date;

    public StockProduct(int amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "StockProduct{" +
                "Quantidade=" + amount +
                ", Data=" + date +
                '}';
    }
}
