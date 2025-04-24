package investasi.Service;

import investasi.Model.User;
import investasi.Util.ClearScreen;
import investasi.Util.InputUtil;
import java.util.ArrayList;
import java.util.List;

import static investasi.View.LoginView.*;

public class AppService {
    private List<User> users = new ArrayList<>();
    private AdminService adminService = new AdminService();
    private CustomerService customerService = new CustomerService();

    public void run() {
        initializeUsers();
        boolean isRunning = true;

        while (isRunning) {
            ClearScreen.clear();
            loginPage();
            System.out.print("Masukan pilihan anda: ");
            int choice = InputUtil.getIntInput(1, 2);

            switch (choice) {
                case 1:
                    User loggedInUser = loginMenu();
                    if (loggedInUser != null) {
                        showRoleMenu(loggedInUser);
                    }
                    break;
                case 2:
                    isRunning = false;
                    System.out.println("Terima kasih!");
                    break;
            }
        }
    }

    private User loginMenu() {
        ClearScreen.clear();
        loginUsernameDanPassword();
        System.out.print("Username: ");
        String username = InputUtil.getStringInput();

        System.out.print("Password: ");
        String password = InputUtil.getStringInput();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("---------------------------------------------------------------------");
                System.out.println("Login berhasil!");
                InputUtil.pressEnterToContinue();
                return user;
            }
        }

        errorLogin();
        InputUtil.pressEnterToContinue();
        return null;
    }

    private void showRoleMenu(User user) {
        boolean isLoggedIn = true;

        while (isLoggedIn) {
            ClearScreen.clear();
            if (user.getRole().equalsIgnoreCase("admin")) {
                adminService.showAdminMenu();
                isLoggedIn = false; // Kembali ke menu utama setelah logout admin
            } else {
                customerService.showCustomerMenu();
                isLoggedIn = false;
            }
        }
    }

    private void initializeUsers() {
        users.add(new User("admin", "admin123", "admin"));
        users.add(new User("customer", "cust123", "customer"));
    }
}