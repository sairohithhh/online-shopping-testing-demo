package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class OrderServiceIntegrationTest {
    @Test
    void orderServiceAndInventoryWorkTogether() {
        InMemoryInventoryService inventory = new InMemoryInventoryService();
        inventory.setStock("Laptop", 1);

        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("Laptop", 1000.00));

        Order order = new OrderService(inventory).checkout(cart);

        assertEquals("CONFIRMED", order.status());
        assertFalse(inventory.isAvailable("Laptop"));
    }
}
