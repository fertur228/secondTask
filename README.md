# Documentation for the assignment 2 BACKEND DEV

## Project Description
The project is a console application for managing orders in a coffee shop. It implements two types of orders: coffee orders and snack orders. The system allows you to enter orders via the console, after which a dynamic receipt with the total amount is generated.

## Project Requirements
1. **Do not use Spring Boot** — the project must be configured manually using Spring Core.
2. **Project structure**:
- Implementation of the service layer (`@Service`)
- Two implementations of the same interface (`OrderService`)
     - `coffeorderservice' (marked `@Primary` — used by default)
- `SnackOrderService' (implemented via `@Qualifier')
- Implementation of the repository layer (`@Repository`)
- Two singleton beans:
     - `Menu' (early initialization, shows the menu at startup)
     - `CheckPrinter' (delayed initialization, prints the receipt after the order)
   - Project configuration using Java configuration (`@Configuration`, `@ComponentScan`, `@Bean`)
- Dependency injection via `@Autowired`
   - Launching the application via the 'AnnotationConfigApplicationContext`

## Description of components

### 1. The 'OrderService` interface
Defines the `placeOrder(String item)` method, which is responsible for placing the order.

### 2. 'OrderService` implementations
- **`coffeorderservice`** (main implementation, marked `@Primary`)
- Accesses the `CoffeeRepository` to check the price and place an order.
  - Displays information about the order and adds it to the receipt.

- **`SnackOrderService`** (implemented via `@Qualifier("snackOrder")')
- Similar to `coffeorderservice`, but works with `SnackRepository'.

###3. Repositories
- **`CoffeeRepository`** stores coffee prices:
  - American - 500tg
  - Espresso - 400tg
  - Lavender raf - 900tg

- **`SnackRepository'** stores prices for snacks:
  - Croissant - 350tg
  - Cake - 500g
  - Bagel - 300tg

### 4. Class `Menu' (early initialization, `@Component')
When the application is launched, it displays the available menu.

### 5. The 'CheckPrinter' class (deferred initialization, `@Lazy`)
Stores a list of ordered items and their cost. After the order is completed, it outputs a receipt with the total amount.

###6. The 'OrderProcessor` class
Contains the `doOrder` method that processes user input. Allows you to place orders and withdraw a receipt.

### 7. Spring Configuration (`ProjectConfig')
- Uses `@Configuration` and `@ComponentScan` to configure the context.

###8. Main class `CoffeeShopApplication`
- Launches the Spring context via the `AnnotationConfigApplicationContext'.
- Requests user input (order of goods).
- Uses the 'OrderProcessor` to process orders.
- Shuts down after the receipt is withdrawn.

## How to launch the app
1. Compile and run the `CoffeeShopApplication'.
2. Enter the names of the products (for example, "Americano", "Croissant").
3. Enter the "receipt" to complete the order and output the total cost.
4. The application displays the final receipt and completes the work.

## Example of how the program works
```
The menu is loaded:
Coffee: Americano - 500tg, Espresso - 400tg, Lavender raf - 900tg
Snacks: Croissant - 350g, Cake - 500g, Bagel - 300g
Enter your order (or 'receipt' to complete):
> American
Order: American | Cost: 500tg
Enter your order (or 'receipt' to complete):
> Croissant
Order: Croissant | Price: 350tg
Enter your order (or 'receipt' to complete):
> receipt
Your receipt:
Americano - 500tg
Croissant - 350g
Total: 850tg
```

## Conclusions
- The project demonstrates the basic principles of Spring Core.
- Two types of orders with different `OrderService` implementations are implemented.
- Early and delayed bean initialization is used.
- Data is stored in memory (`Map').
- The Spring context is started manually via the `AnnotationConfigApplicationContext'.
# Документация к заданию "Кофейня"

## Описание проекта
Проект представляет собой консольное приложение для управления заказами в кофейне. В нем реализованы два типа заказов: заказы на кофе и заказы на закуски. Система позволяет вводить заказы через консоль, после чего формируется динамический чек с итоговой суммой.

## Требования к проекту
1. **Не использовать Spring Boot** — проект должен быть настроен вручную с использованием Spring Core.
2. **Структура проекта**:
   - Реализация сервисного слоя (`@Service`)
   - Две реализации одного интерфейса (`OrderService`)
     - `CoffeeOrderService` (помечен `@Primary` — используется по умолчанию)
     - `SnackOrderService` (внедряется через `@Qualifier`)
   - Реализация слоя репозиториев (`@Repository`)
   - Два синглтон-бина:
     - `Menu` (ранняя инициализация, показывает меню при запуске)
     - `CheckPrinter` (отложенная инициализация, печатает чек после заказа)
   - Настройка проекта с использованием Java-конфигурации (`@Configuration`, `@ComponentScan`, `@Bean`)
   - Внедрение зависимостей через `@Autowired`
   - Запуск приложения через `AnnotationConfigApplicationContext`

## Описание компонентов

### 1. Интерфейс `OrderService`
Определяет метод `placeOrder(String item)`, который отвечает за оформление заказа.

### 2. Реализации `OrderService`
- **`CoffeeOrderService`** (основная реализация, помечена `@Primary`)
  - Обращается к `CoffeeRepository` для проверки цены и оформления заказа.
  - Выводит информацию о заказе и добавляет его в чек.

- **`SnackOrderService`** (внедряется через `@Qualifier("snackOrder")`)
  - Аналогично `CoffeeOrderService`, но работает с `SnackRepository`.

### 3. Репозитории
- **`CoffeeRepository`** хранит цены на кофе:
  - Американо - 500тг
  - Эспрессо - 400тг
  - Лавандовый раф - 900тг

- **`SnackRepository`** хранит цены на закуски:
  - Круассан - 350тг
  - Пирожное - 500тг
  - Бублик - 300тг

### 4. Класс `Menu` (ранняя инициализация, `@Component`)
При запуске приложения выводит доступное меню.

### 5. Класс `CheckPrinter` (отложенная инициализация, `@Lazy`)
Хранит список заказанных товаров и их стоимость. После завершения заказа выводит чек с итоговой суммой.

### 6. Класс `OrderProcessor`
Содержит метод `doOrder`, который обрабатывает ввод пользователя. Позволяет оформить заказы и вывести чек.

### 7. Конфигурация Spring (`ProjectConfig`)
- Использует `@Configuration` и `@ComponentScan` для настройки контекста.

### 8. Главный класс `CoffeeShopApplication`
- Запускает контекст Spring через `AnnotationConfigApplicationContext`.
- Запрашивает ввод пользователя (заказ товаров).
- Использует `OrderProcessor` для обработки заказов.
- Завершает работу после вывода чека.

## Как запустить приложение
1. Скомпилировать и запустить `CoffeeShopApplication`.
2. Ввести названия товаров (например, "Американо", "Круассан").
3. Ввести "чек" для завершения заказа и вывода итоговой стоимости.
4. Приложение выведет итоговый чек и завершит работу.

## Пример работы программы
```
Меню загружено:
Кофе: Американо - 500тг, Эспрессо - 400тг, Лавандовый раф - 900тг
Закуски: Круассан - 350тг, Пирожное - 500тг, Бублик - 300тг
Введите ваш заказ (или 'чек' для завершения):
> Американо
Заказ: Американо | Стоимость: 500тг
Введите ваш заказ (или 'чек' для завершения):
> Круассан
Заказ: Круассан | Стоимость: 350тг
Введите ваш заказ (или 'чек' для завершения):
> чек
Ваш чек:
Американо - 500тг
Круассан - 350тг
Итого: 850тг
```

## Выводы
- Проект демонстрирует основные принципы Spring Core.
- Реализованы два вида заказов с разными реализациями `OrderService`.
- Используется ранняя и отложенная инициализация бинов.
- Данные хранятся в памяти (`Map`).
- Контекст Spring запускается вручную через `AnnotationConfigApplicationContext`.

