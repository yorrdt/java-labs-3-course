package com.example.lab5;

import com.example.lab5.database.*;
import com.example.lab5.model.Car;
import com.example.lab5.model.Flight;
import com.example.lab5.model.User;
import com.example.lab5.service.AuthService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarStateService carStateService = new CarStateService();
        carStateService.createTable();
        // carStateService.setTableStates();

        CarService carService = new CarService();
        carService.createTable();

        FlightService flightService = new FlightService();
        flightService.createTable();

        RoleService roleService = new RoleService();
        roleService.createTable();
        // roleService.setTableRoles();

        UserService userService = new UserService();
        userService.createTable();

        UserFlightRelation userFlightRelation = new UserFlightRelation();
        userFlightRelation.createTable();

        // userService.addUser(new User(0, "Alex", "password", false, 0));

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("ConsoleApp v2.3");
            System.out.println("Возможные действия: ");
            System.out.println("1. Войти");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Имя: ");
                String name = scanner.nextLine();

                System.out.print("Пароль: ");
                String password = scanner.nextLine();

                AuthService authService = new AuthService();
                User user = authService.loginUser(name, password);

                if (user == null) {
                    continue;
                }

                switch (user.getRole()) {
                    case 0: {
                        showAdminMenu(scanner, user);
                        break;
                    }
                    case 1: {
                        showManagerMenu(scanner, user);
                        break;
                    }
                    case 2: {
                        showDriverMenu(scanner, user);
                        break;
                    }
                    default: {
                        System.err.println("Wrong role!");
                        break;
                    }
                }
                break;
            }

            System.err.println("[INFO]: Некорректный выбор.");
        }
    }

    private static void showDriverMenu(Scanner scanner, User user) {
        while (true) {

            if (!user.isAuthenticated()) {
                return;
            }

            System.out.println("Водитель " + user.getName());
            System.out.println("Возможные действия: ");
            System.out.println("1. Вывести список рейсов");
            System.out.println("2. Выполнить рейс");
            System.out.println("3. Вывести список автомобилей");
            System.out.println("4. Выйти из системы");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    FlightService flightService = new FlightService();
                    List<Flight> flights = flightService.getAllFlightsForDriver(user.getId());

                    System.out.println("----------------------< Список рейсов >---------------------");
                    for (Flight f : flights) {
                        System.out.println(f.getUserId() + " " +
                                f.getId() + " " +
                                f.getComingFrom() + " " +
                                f.getArriveIn() + " " +
                                f.isCompleted() + " " +
                                f.getCarName() + " " +
                                f.getCarNumber()
                        );
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("----------------------< Выполнить рейс >--------------------");

                    System.out.print("Id выполненного рейса: ");
                    int flightId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Состояние автомобиля (0 - Нормальное, 1 - Среднее, 2 - Критическое): ");
                    int carState = scanner.nextInt();
                    scanner.nextLine();

                    FlightService flightService = new FlightService();
                    flightService.completeFlight(flightId);

                    CarService carService = new CarService();
                    carService.setCarState(flightService.getFlightById(flightId), carState);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Рейс выполнен, исправность автомобиля установлена!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 3: {
                    CarService carService = new CarService();
                    List<Car> carList = carService.getAllCars();

                    System.out.println("-------------------< Список автомобилей >-------------------");
                    for (Car c : carList) {
                        System.out.println(c.getId() + " " + c.getName() + " " + c.getNumber() + " " + c.getCarStateId());
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 4: {
                    UserService userService = new UserService();
                    userService.updateUserAuth(user.getId(), false);
                    user.setAuthenticated(false);
                    System.out.println("Выход из системы...");
                    break;
                }
                default: {
                    System.err.println("[INFO]: Некорректный выбор.");
                    break;
                }
            }
        }
    }

    private static void showManagerMenu(Scanner scanner, User user) {
        while (true) {

            if (!user.isAuthenticated()) {
                return;
            }

            System.out.println("Диспетчер " + user.getName());
            System.out.println("Возможные действия: ");
            System.out.println("1. Создать рейс");
            System.out.println("2. Удалить рейс");
            System.out.println("3. Вывести список рейсов");
            System.out.println("4. Добавить автомобиль");
            System.out.println("5. Удалить автомобиль");
            System.out.println("6. Вывести список автомобилей");
            System.out.println("7. Вывести список водителей");
            System.out.println("8. Выйти из системы");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("---------------------< Создание рейса >---------------------");

                    System.out.print("ID водителя, который будет учавствовать в рейсе: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Точка отправления: ");
                    String comingFrom = scanner.nextLine();

                    System.out.print("Точка прибытия: ");
                    String arriveIn = scanner.nextLine();

                    System.out.print("ID автомобиля: ");
                    int carId = scanner.nextInt();
                    scanner.nextLine();

                    FlightService flightService = new FlightService();
                    flightService.addFlight(userId, new Flight(0, comingFrom, arriveIn, false), carId);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Рейс добавлен!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("---------------------< Удаление рейса >---------------------");

                    System.out.print("ID рейса: ");
                    int flightId = scanner.nextInt();

                    FlightService flightService = new FlightService();
                    flightService.deleteFlight(flightId);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Рейс удален, водитель отстранен!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 3: {
                    FlightService flightService = new FlightService();
                    List<Flight> flights = flightService.getAllFlights();

                    System.out.println("----------------------< Список рейсов >---------------------");
                    for (Flight f : flights) {
                        System.out.println(f.getUserId() + " " +
                                f.getId() + " " +
                                f.getComingFrom() + " " +
                                f.getArriveIn() + " " +
                                f.isCompleted() + " " +
                                f.getCarName() + " " +
                                f.getCarNumber()
                        );
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 4: {
                    System.out.println("------------------< Добавить автомобиль >------------------");

                    System.out.print("Название автомобиля: ");
                    String carName = scanner.nextLine();

                    System.out.print("Номер: ");
                    String carNumber = scanner.nextLine();

                    CarService carService = new CarService();
                    carService.addCar(carName, carNumber);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Автомобиль добавлен!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 5: {
                    System.out.println("-------------------< Удаление автомобиля >------------------");
                    System.out.print("Введите id автомобиля: ");
                    int carId = scanner.nextInt();

                    CarService carService = new CarService();
                    carService.deleteCar(carId);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Автомобиль удален!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 6: {
                    CarService carService = new CarService();
                    List<Car> carList = carService.getAllCars();

                    System.out.println("-------------------< Список автомобилей >-------------------");
                    for (Car c : carList) {
                        System.out.println(c.getId() + " " + c.getName() + " " + c.getNumber() + " " + c.getCarStateId());
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 7: {
                    System.out.println("---------------------< Список водителей >-------------------");
                    UserService userService = new UserService();
                    List<User> userList = userService.filterUserByRole(2);

                    for (User u : userList) {
                        System.out.println(u.getId() + " " + u.getName() + " " + u.getPassword() + " " + u.getRole());
                    }

                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 8: {
                    UserService userService = new UserService();
                    userService.updateUserAuth(user.getId(), false);
                    user.setAuthenticated(false);
                    System.out.println("Выход из системы...");
                    break;
                }
                default: {
                    System.err.println("[INFO]: Некорректный выбор.");
                    break;
                }
            }
        }
    }

    private static void showAdminMenu(Scanner scanner, User user) {

        while (true) {

            if (!user.isAuthenticated()) {
                return;
            }

            System.out.println("Админ " + user.getName());
            System.out.println("Возможные действия: ");
            System.out.println("1. Вывести список пользователей");
            System.out.println("2. Добавить пользователя");
            System.out.println("3. Удалить пользователя");
            System.out.println("4. Вывести список диспетчеров");
            System.out.println("5. Вывести список водителей");
            System.out.println("6. Вывести список рейсов");
            System.out.println("7. Выйти из системы");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    UserService userService = new UserService();
                    List<User> userList = userService.getAllUsers();

                    System.out.println("------------------< Список пользователей >------------------");
                    for (User u : userList) {
                        System.out.println(u.getId() + " " + u.getName() + " " + u.getPassword() + " " + u.getRole());
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 2: {
                    System.out.println("-------------< Добавление нового пользователя >-------------");
                    System.out.print("Имя: ");
                    String name = scanner.nextLine();

                    System.out.print("Пароль: ");
                    String password = scanner.nextLine();

                    System.out.print("Роль пользователя (1 - Менеджер, 2 - Водитель): ");
                    int role_id = scanner.nextInt();

                    UserService userService = new UserService();
                    userService.addUser(new User(0, name, password, false, role_id));

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Пользователь добавлен!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 3: {
                    System.out.println("------------------< Удаление пользователя >-----------------");
                    System.out.print("Введите id пользователя: ");
                    int userId = scanner.nextInt();

                    UserService userService = new UserService();
                    userService.deleteUser(userId);

                    System.out.println("------------------------------------------------------------");
                    System.out.println("Пользователь удален!");
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 4: {
                    System.out.println("--------------------< Список деспетчеров >------------------");
                    UserService userService = new UserService();
                    List<User> userList = userService.filterUserByRole(1);

                    for (User u : userList) {
                        System.out.println(u.getId() + " " + u.getName() + " " + u.getPassword() + " " + u.getRole());
                    }

                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 5: {
                    System.out.println("---------------------< Список водителей >-------------------");
                    UserService userService = new UserService();
                    List<User> userList = userService.filterUserByRole(2);

                    for (User u : userList) {
                        System.out.println(u.getId() + " " + u.getName() + " " + u.getPassword() + " " + u.getRole());
                    }

                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 6: {
                    FlightService flightService = new FlightService();
                    List<Flight> flights = flightService.getAllFlights();

                    System.out.println("----------------------< Список рейсов >---------------------");
                    for (Flight f : flights) {
                        System.out.println(f.getUserId() + " " +
                                f.getId() + " " +
                                f.getComingFrom() + " " +
                                f.getArriveIn() + " " +
                                f.isCompleted() + " " +
                                f.getCarName() + " " +
                                f.getCarNumber()
                        );
                    }
                    System.out.println("------------------------------------------------------------");
                    break;
                }
                case 7: {
                    UserService userService = new UserService();
                    userService.updateUserAuth(user.getId(), false);
                    user.setAuthenticated(false);
                    System.out.println("Выход из системы...");
                    break;
                }
                default: {
                    System.err.println("[INFO]: Некорректный выбор.");
                    break;
                }
            }
        }
    }
}
