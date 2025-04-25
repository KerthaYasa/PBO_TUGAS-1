package investasi.Util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput() {
        try {
            return scanner.nextLine().trim();
        } catch (Exception e) {
            System.out.println("Error membaca input: " + e.getMessage());
            return "";
        }
    }

    public static int getIntInput(int min, int max) {
        while (true) {
            try {
                System.out.flush();
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Masukkan angka antara %d sampai %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Masukkan angka: ");
            }
        }
    }

    public static double getDoubleInput() {
        while (true) {
            try {
                System.out.flush();
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Input tidak valid. Masukkan angka desimal: ");
            }
        }
    }

    public static double getDoubleInput(double min) {
        while (true) {
            double input = getDoubleInput();
            if (input >= min) {
                return input;
            }
            System.out.printf("Masukkan angka lebih besar atau sama dengan %.2f: ", min);
        }
    }

    public static void pressEnterToContinue() {
        System.out.print("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}