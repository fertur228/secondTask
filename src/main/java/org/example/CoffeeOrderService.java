package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
class CoffeeOrderService implements OrderService {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeOrderService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public void placeOrder(String item) {
        Integer price = coffeeRepository.getPrice(item);
        if (price != null) {
            System.out.println("Заказ: " + item + " | Стоимость: " + price + "тг");
            CheckPrinter.addToReceipt(item, price);
        } else {
            System.out.println("Такого кофе нет в меню.");
        }
    }
}
