package com.example.lab;

import com.example.lab.model.User;
import com.example.lab.service.AuthService;
import com.example.lab.service.UserDB;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("ShittyConsoleApp v2.3");
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

                User user = authService.loginUser(name, password);
                if (user.getName() == null) {
                    System.out.println("User not found");
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
                        System.out.println("Wrong role!");
                        break;
                    }
                }
                break;
            }

            System.out.println("[INFO]: Некорректный выбор.");
        }
    }

    private static void showDriverMenu(Scanner scanner, User user) {
        while (true) {

            System.out.println("Водитель " + user.getName());
            System.out.println("Возможные действия: ");
            System.out.println("1. Вывести список рейсов");
            System.out.println("2. Вывести список авто");
            System.out.println("3. Выйти из системы");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            }
        }
    }

    private static void showManagerMenu(Scanner scanner, User user) {
        while (true) {

            System.out.println("Диспетчер " + user.getName());
            System.out.println("Возможные действия: ");
            System.out.println("1. Создать рейс");
            System.out.println("2. Вывести список рейсов");
            System.out.println("3. Вывести список водителей");
            System.out.println("4. Вывести список автомобилей");
            System.out.println("5. Выйти из системы");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            }
        }
    }

    private static void showAdminMenu(Scanner scanner, User user) {
        while (true) {

            System.out.println("Админ " + user.getName());
            System.out.println("Возможные действия: ");
            System.out.println("1. Вывести список пользователей");
            System.out.println("2. Выйти из системы");

            System.out.print("> ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    UserDB userDB = new UserDB();
                    List<User> entriesList = userDB.getAllEntries();

                    for (User u : entriesList) {
                        System.out.println(u.getId() + " " + u.getName() + " " + u.getRole() + " " + u.isAuthenticated());
                    }

                    break;
                }
                case 2: {

                    break;
                }
                default: {
                    System.out.println("[INFO]: Некорректный выбор.");
                    break;
                }
            }
        }
    }
}
