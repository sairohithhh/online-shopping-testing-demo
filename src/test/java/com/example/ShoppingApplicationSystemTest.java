package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShoppingApplicationSystemTest {
    @Test
    void completeApplicationCreatesAnOrder() {
        PrintStream original = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(captured));
            ShoppingApplication.main(new String[0]);
        } finally {
            System.setOut(original);
        }

        String output = captured.toString();
        assertAll(
                () -> assertTrue(output.contains("Order status: CONFIRMED")),
                () -> assertTrue(output.contains("Total: $1000.0"))
        );
    }
}
