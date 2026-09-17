package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product is required");
        }
        products.add(product);
    }

    public List<Product> products() {
        return Collections.unmodifiableList(products);
    }

    public double total() {
        return products.stream().mapToDouble(Product::price).sum();
    }
}
