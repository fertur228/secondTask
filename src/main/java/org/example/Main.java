package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Scanner scanner = new Scanner(System.in);

        OrderProcessor orderProcessor = context.getBean(OrderProcessor.class);
        orderProcessor.doOrder(scanner);
    }
}