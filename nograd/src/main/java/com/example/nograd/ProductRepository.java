package com.example.nograd;

import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private static final List<Product> products = List.of(
            new Product("Chess", "Board Game", 100),
            new Product("Thinking Cap", "Wearable", 200),
            new Product("Kayak", "Some kind of boat", 300)
    );

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.name().equalsIgnoreCase(name))
                .findFirst();
    }
}
