package investasi.View;

public class AdminView {

    public static void adminMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                            Admin Menu                           ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||                                                                 ||");
        System.out.println("||   [1] Saham                                                     ||");
        System.out.println("||   [2] SBN                                                       ||");
        System.out.println("||   [3] Logout                                                    ||");
        System.out.println("=====================================================================");
        System.out.print("Masukkan pilihan opsi: ");
    }

    public static void adminSahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                            S A H A M                            ||");
        System.out.println("||                            Admin Menu                           ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||                                                                 ||");
        System.out.println("||   [1] Tambah Saham                                              ||");
        System.out.println("||   [2] Ubah Harga Saham                                          ||");
        System.out.println("||   [3] Kembali                                                   ||");
        System.out.println("=====================================================================");
        System.out.print("Masukkan pilihan opsi: ");
    }

    public static void tambahSahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                     T A M B A H  S A H A M                      ||");
        System.out.println("||    Mohon Masukkan Kode Saham, Nama Perusahaan dan Harga Saham   ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void ubahHargaSahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                  U B A H  H A R G A  S A H A M                  ||");
        System.out.println("||   Mohon Masukkan Kode Saham dan Ubah Harga Saham yang Tersedia  ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void adminSbnMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                              S B N                              ||");
        System.out.println("||                            Admin Menu                           ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||                                                                 ||");
        System.out.println("||   [1] Tambah SBN                                                ||");
        System.out.println("||   [2] Kembali                                                   ||");
        System.out.println("=====================================================================");
        System.out.print("Masukkan pilihan opsi: ");
    }

    public static void tambahSbnMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                       T A M B A H  S B N                        ||");
        System.out.println("||  Masukkan Nama SBN, Bunga, Jangka Waktu, Jatuh Tempo dan Kuota  ||");
        System.out.println("---------------------------------------------------------------------");
    }

}