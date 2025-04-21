package controller;

import model.*;
import view.Menu;
import util.DataStorage;

import java.util.Scanner;

public class AppController {
    private Scanner scanner = new Scanner(System.in);
    private DataStorage storage = new DataStorage();
    private Account currentUser;

    public void run() {
        while (true) {
            Menu.showLoginMenu();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            currentUser = storage.login(username, password);

            if (currentUser == null) {
                System.out.println("Login gagal! Coba lagi.\n");
                continue;
            }

            if (currentUser instanceof Admin) handleAdmin();
            else if (currentUser instanceof Customer) handleCustomer();
        }
    }

    private void handleAdmin() {
        while (true) {
            Menu.showAdminMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> handleAdminSaham();
                case 2 -> handleAdminSBN();
                case 3 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void handleAdminSaham() {
        while (true) {
            Menu.showAdminSahamMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> storage.addSaham(scanner);
                case 2 -> storage.updateSaham(scanner);
                case 3 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void handleAdminSBN() {
        while (true) {
            Menu.showAdminSBNMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> storage.addSBN(scanner);
                case 2 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    private void handleCustomer() {
        Customer customer = (Customer) currentUser;
        while (true) {
            Menu.showCustomerMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> storage.buySaham(customer, scanner);
                case 2 -> storage.sellSaham(customer, scanner);
                case 3 -> storage.buySBN(customer, scanner);
                case 4 -> storage.simulateSBN(customer, scanner);
                case 5 -> storage.viewPortfolio(customer);
                case 6 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }
}