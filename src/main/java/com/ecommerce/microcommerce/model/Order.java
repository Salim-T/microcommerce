package com.ecommerce.microcommerce.model;

public class Order {
    private int id;
    private String description;
    private double total;

    public Order() {}

    public Order(int id, String description, double total) {
        this.id = id;
        this.description = description;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
