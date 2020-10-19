package main;

import controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller control = new Controller();
        String role = "JUNIOR";

        System.out.println("Добро пожаловать в библиотеку\n" + "Доступные команды ([] - default):\n"
                + "ADDBOOK [title = Unknown] [price = 0] [role = JUNIOR]\n" + "LOGIN login password\n"
                + "SIGNUP login password\n" + "CHANGEROLE target_user_login [new_role = ADULT]\n" + "SHOWLIB\n");

        String line = "";
        System.out.print("Введите команду: ");

        if (scanner.hasNextLine()) {
            line = scanner.nextLine();
        } else {
            System.out.println("Возникла ошибка, попробуйте повторить запрос позже");
        }

        while (!line.equals("EXIT") && !line.equals("Exit") && !line.equals("exit")) {

            String[] response = control.doAction(role + " " + line).split("\\s+");

            role = response[0];

            for (int i = 1; i < response.length; i++) {
                System.out.print(response[i] + " ");
            }
            System.out.println();

            System.out.print("Введите команду: ");

            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
            } else {
                System.out.println("Возникла ошибка, попробуйте повторить запрос позже");
            }
        }

        scanner.close();
    }
}
