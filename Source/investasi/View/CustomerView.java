package investasi.View;

public class CustomerView {
    public static void loggedInGreetingCustomer(String userName) {
        System.out.println("=====================================================================");
        System.out.printf("||                   Hallo Customer, %-30s||\n", userName);
        System.out.println("||                                                                 ||");
        System.out.println("||                  Tekan Enter untuk melanjutkan                  ||");
        System.out.println("=====================================================================");
    }

    public static void customerMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                          Customer Menu                          ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||                                                                 ||");
        System.out.println("||   [1] Beli Saham                                                ||");
        System.out.println("||   [2] Jual Saham                                                ||");
        System.out.println("||   [3] Beli SBN                                                  ||");
        System.out.println("||   [4] Simulasi SBN                                              ||");
        System.out.println("||   [5] Portofolio                                                ||");
        System.out.println("||   [6] Logout                                                    ||");
        System.out.println("=====================================================================");
        System.out.print("Masukkan pilihan opsi: ");
    }

    public static void customerBeliSahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                       B E L I  S A H A M                        ||");
        System.out.println("||  Pilih Saham yang Tersedia dan Jumlah Lembar yang Ingin Dibeli  ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void customerJualSahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                       J U A L  S A H A M                        ||");
        System.out.println("||       Pilih Saham Anda dan Jumlah Lembar yang Ingin Dijual      ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void customerBeliSbnMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                         B E L I  S B N                          ||");
        System.out.println("||   Pilih SBN yang Tersedia dan Masukkan Nominal yang Diinginkan  ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void customerSimulasiSbnMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                    S I M U L A S I  S B N                       ||");
        System.out.println("||             Pilih SBN yang Ingin Anda Simulasikan               ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void customerPortofolioMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                      P O R T O F O L I O                        ||");
        System.out.println("---------------------------------------------------------------------");
    }

}