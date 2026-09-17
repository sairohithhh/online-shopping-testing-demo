package com.example;

public interface InventoryService {
    boolean isAvailable(String productName);
    void removeOne(String productName);
}
