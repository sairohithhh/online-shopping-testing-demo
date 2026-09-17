package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CheckoutFunctionalTest {
    @Test
    void customerCanBuyAvailableProducts() {
        InMemoryInventoryService inventory = new InMemoryInventoryService();
        inventory.setStock("Keyboard", 2);
        inventory.setStock("Mouse", 3);

        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("Keyboard", 50.00));
        cart.add(new Product("Mouse", 25.00));

        Order order = new OrderService(inventory).checkout(cart);

        assertAll(
                () -> assertEquals("CONFIRMED", order.status()),
                () -> assertEquals(75.00, order.total()),
                () -> assertEquals(2, order.products().size())
        );
    }

    @Test
    void customerCannotBuyAnOutOfStockProduct() {
        InMemoryInventoryService inventory = new InMemoryInventoryService();
        inventory.setStock("Laptop", 0);

        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("Laptop", 1000.00));

        assertThrows(
                IllegalStateException.class,
                () -> new OrderService(inventory).checkout(cart)
        );
    }
}
