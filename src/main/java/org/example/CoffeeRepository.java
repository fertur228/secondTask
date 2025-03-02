package org.example;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
class CoffeeRepository {
    private final Map<String, Integer> coffeePrices = Map.of(
            "Американо", 500,
            "Эспрессо", 400,
            "Лавандовый раф", 900
    );

    public Integer getPrice(String coffee) {
        return coffeePrices.get(coffee);
    }
}
