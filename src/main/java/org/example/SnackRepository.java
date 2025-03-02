package org.example;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
class SnackRepository {
    private final Map<String, Integer> snackPrices = Map.of(
            "Круассан", 350,
            "Пирожное", 500,
            "Бублик", 300
    );

    public Integer getPrice(String snack) {
        return snackPrices.get(snack);
    }
}
