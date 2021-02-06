package model;

import java.util.LinkedList;
import java.util.Queue;

public class Products {

    protected int id;
    protected String name;
    Queue<StockProduct> stock = new LinkedList<>();
    int number_stock;

    public Products(int id, String name, Queue<StockProduct> stock, int number_stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.number_stock = number_stock;
    }

    public int getNumber_stock() {
        return number_stock;
    }

    public void setNumber_stock(int number_stock) {
        this.number_stock = number_stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Queue<StockProduct> getStock() {
        return stock;
    }

    public void setStock(Queue<StockProduct> stock) {
        this.stock = stock;
    }
}