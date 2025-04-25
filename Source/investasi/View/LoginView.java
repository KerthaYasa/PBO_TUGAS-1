package investasi.View;

public class LoginView {
    public static void loginPage(){
        System.out.println("=====================================================================");
        System.out.println("||                          W E L C O M E                          ||");
        System.out.println("||                           LOGIN PAGE                            ||");
        System.out.println("||     PROGRAM INVESTASI SAHAM DAN SURAT BERHARGA NEGARA (SBN)     ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||                                                                 ||");
        System.out.println("||              [1] Login                  [2] Keluar              ||");
        System.out.println("=====================================================================");
    }

    public static void loginUsernameDanPassword() {
        System.out.println("=====================================================================");
        System.out.println("||                              L O G I N                          ||");
        System.out.println("||      Mohon Masukkan Username dan Password untuk melanjutkan     ||");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void errorLogin() {
        System.out.println("=====================================================================");
        System.out.println("||                            Log In Gagal                         ||");
        System.out.println("||                                                                 ||");
        System.out.println("||              Periksa Kembali Username dan Password Anda         ||");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("||                  Tekan Enter untuk melanjutkan                  ||");
        System.out.println("=====================================================================");
    }
}

