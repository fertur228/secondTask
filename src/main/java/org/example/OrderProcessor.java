package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
class OrderProcessor {
    private final OrderService coffeeOrderService;
    private final OrderService snackOrderService;
    private final CheckPrinter checkPrinter;
    private final CoffeeRepository coffeeRepository;
    private final SnackRepository snackRepository;

    @Autowired
    public OrderProcessor(CoffeeOrderService coffeeOrderService, @Qualifier("snackOrder") OrderService snackOrderService,
                          CheckPrinter checkPrinter, CoffeeRepository coffeeRepository, SnackRepository snackRepository) {
        this.coffeeOrderService = coffeeOrderService;
        this.snackOrderService = snackOrderService;
        this.checkPrinter = checkPrinter;
        this.coffeeRepository = coffeeRepository;
        this.snackRepository = snackRepository;
    }

    public void doOrder(Scanner scanner) {
        while (true) {
            System.out.println("Введите ваш заказ (или 'чек' для завершения):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("чек")) {
                checkPrinter.printReceipt();
                break;
            }

            if (coffeeRepository.getPrice(input) != null) {
                coffeeOrderService.placeOrder(input);
            } else if (snackRepository.getPrice(input) != null) {
                snackOrderService.placeOrder(input);
            } else {
                System.out.println("Такого товара нет в меню.");
            }
        }
    }
}
