package com.renanzulian.xmlproject.jaxb;

import com.renanzulian.xmlproject.models.Product;

import java.util.List;

public class Sales {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
