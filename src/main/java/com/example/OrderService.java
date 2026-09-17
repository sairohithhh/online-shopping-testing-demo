package com.example;

public class OrderService {
    private final InventoryService inventory;

    public OrderService(InventoryService inventory) {
        this.inventory = inventory;
    }

    public Order checkout(ShoppingCart cart) {
        if (cart.products().isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        for (Product product : cart.products()) {
            if (!inventory.isAvailable(product.name())) {
                throw new IllegalStateException(product.name() + " is out of stock");
            }
        }

        for (Product product : cart.products()) {
            inventory.removeOne(product.name());
        }

        return new Order(cart.products(), cart.total(), "CONFIRMED");
    }
}
