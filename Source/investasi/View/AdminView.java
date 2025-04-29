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
        System.out.println("||   [3] Lihat Daftar Saham                                        ||");
        System.out.println("||   [4] Hapus Saham                                               ||");
        System.out.println("||   [5] Kembali                                                   ||");
        System.out.println("=====================================================================");
        System.out.print("Masukkan pilihan opsi: ");
    }

    public static void tambahSahamMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                     T A M B A H  S A H A M                      ||");
        System.out.println("||    Mohon Masukkan Kode Saham, Nama Perusahaan dan Harga Saham   ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void listSahamView() {
        System.out.println("=====================================================================");
        System.out.println("||                     D A F T A R  S A H A M                      ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void deleteSaham() {
        System.out.println("=====================================================================");
        System.out.println("||                      H A P U S  S A H A M                       ||");
        System.out.println("||                  Pilih Saham yang Ingin Dihapus                 ||");
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
        System.out.println("||   [2] Lihat Daftar SBN                                          ||");
        System.out.println("||   [3] Hapus SBN                                                 ||");
        System.out.println("||   [4] Kembali                                                   ||");
        System.out.println("=====================================================================");
        System.out.print("Masukkan pilihan opsi: ");
    }

    public static void tambahSbnMenu() {
        System.out.println("=====================================================================");
        System.out.println("||                       T A M B A H  S B N                        ||");
        System.out.println("||  Masukkan Nama SBN, Bunga, Jangka Waktu, Jatuh Tempo dan Kuota  ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void listSbnView() {
        System.out.println("=====================================================================");
        System.out.println("||                       D A F T A R  S B N                        ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void deleteSBN() {
        System.out.println("=====================================================================");
        System.out.println("||                        H A P U S  S B N                         ||");
        System.out.println("||                   Pilih SBN yang Ingin Dihapus                  ||");
        System.out.println("---------------------------------------------------------------------");
    }

}