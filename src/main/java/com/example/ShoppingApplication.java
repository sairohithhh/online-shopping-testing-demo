package com.example;

public class ShoppingApplication {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 1000.00);
        ShoppingCart cart = new ShoppingCart();
        cart.add(laptop);

        InMemoryInventoryService inventory = new InMemoryInventoryService();
        inventory.setStock("Laptop", 2);

        OrderService orderService = new OrderService(inventory);
        Order order = orderService.checkout(cart);

        System.out.println("Order status: " + order.status());
        System.out.println("Total: $" + order.total());
    }
}
