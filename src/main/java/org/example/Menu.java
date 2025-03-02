package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
class Menu {
    public Menu() {
        System.out.println("Меню загружено:");
        System.out.println("Кофе: Американо - 500тг, Эспрессо - 400тг, Лавандовый раф - 900тг");
        System.out.println("Закуски: Круассан - 350тг, Пирожное - 500тг, Бублик - 300тг");
    }
}
