package com.example;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryService implements InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public void setStock(String productName, int quantity) {
        stock.put(productName, quantity);
    }

    @Override
    public boolean isAvailable(String productName) {
        return stock.getOrDefault(productName, 0) > 0;
    }

    @Override
    public void removeOne(String productName) {
        if (!isAvailable(productName)) {
            throw new IllegalStateException(productName + " is out of stock");
        }
        stock.put(productName, stock.get(productName) - 1);
    }
}
