package com.example;

import java.util.List;

public record Order(List<Product> products, double total, String status) {
}
