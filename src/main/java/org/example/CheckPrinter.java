package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
class CheckPrinter {
    private static final StringBuilder receipt = new StringBuilder();
    private static int total = 0;

    public static void addToReceipt(String item, int price) {
        receipt.append(item).append(" - ").append(price).append("тг\n");
        total += price;
    }

    public void printReceipt() {
        System.out.println("Ваш чек:");
        System.out.print(receipt);
        System.out.println("Итого: " + total + "тг");
    }
}
