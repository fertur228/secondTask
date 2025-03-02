package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("snackOrder")
class SnackOrderService implements OrderService {
    private final SnackRepository snackRepository;

    @Autowired
    public SnackOrderService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    @Override
    public void placeOrder(String item) {
        Integer price = snackRepository.getPrice(item);
        if (price != null) {
            System.out.println("Заказ: " + item + " | Стоимость: " + price + "тг");
            CheckPrinter.addToReceipt(item, price);
        } else {
            System.out.println("Такой закуски нет в меню.");
        }
    }
}
