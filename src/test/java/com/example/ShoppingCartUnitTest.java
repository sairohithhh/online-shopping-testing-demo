package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingCartUnitTest {
    @Test
    void calculatesTheTotalOfProducts() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("Keyboard", 50.00));
        cart.add(new Product("Mouse", 25.00));

        assertEquals(75.00, cart.total());
    }

    @Test
    void rejectsANullProduct() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.add(null));
    }
}
