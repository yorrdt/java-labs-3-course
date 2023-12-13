package com.example.helloworld;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.print("Введите имя: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.println("Добро пожаловать, " + name);
    }
}
