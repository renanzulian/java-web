package com.renanzulian.xmlproject;

import java.text.NumberFormat;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "Name: " + this.name + "\n" +
                "Price: $" + formatter.format(this.price) + "\n";
    }
}
