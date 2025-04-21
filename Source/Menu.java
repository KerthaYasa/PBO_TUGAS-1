package view;

public class Menu {
    public static void showLoginMenu() {
        System.out.println("\n== Menu Login ==");
    }

    public static void showAdminMenu() {
        System.out.println("\n== Admin Menu ==\n1. Saham\n2. SBN\n3. Logout");
    }

    public static void showAdminSahamMenu() {
        System.out.println("\n== Admin Saham ==\n1. Tambah Saham\n2. Ubah Harga Saham\n3. Kembali");
    }

    public static void showAdminSBNMenu() {
        System.out.println("\n== Admin SBN ==\n1. Tambah SBN\n2. Kembali");
    }

    public static void showCustomerMenu() {
        System.out.println("\n== Menu Customer ==\n1. Beli Saham\n2. Jual Saham\n3. Beli SBN\n4. Simulasi SBN\n5. Portofolio\n6. Logout");
    }
}
