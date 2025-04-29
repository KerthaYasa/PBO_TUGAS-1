package investasi.Service;

import investasi.Model.Saham;
import investasi.Model.SBN;
import investasi.Util.ClearScreen;
import investasi.Util.DataStorage;
import investasi.Util.InputUtil;
import java.time.LocalDate;
import java.util.List;

import static investasi.View.AdminView.*;

public class AdminService implements InvestasiService {
    private DataStorage dataStorage = DataStorage.getInstance();

    public void showAdminMenu() {
        boolean isAdminActive = true;

        while (isAdminActive) {
            ClearScreen.clear();
            adminMenu();
            int choice = InputUtil.getIntInput(1, 3);

            switch (choice) {
                case 1:
                    kelolaSaham();
                    break;
                case 2:
                    kelolaSBN();
                    break;
                case 3:
                    isAdminActive = false;
                    System.out.println("Logout berhasil!");
                    InputUtil.pressEnterToContinue();
                    break;
            }
        }
    }

    private void kelolaSaham() {
        boolean isSahamMenuActive = true;

        while (isSahamMenuActive) {
            ClearScreen.clear();
            adminSahamMenu();
            int choice = InputUtil.getIntInput(1, 5);

            switch (choice) {
                case 1:
                    tambahSaham();
                    break;
                case 2:
                    ubahHargaSaham();
                    break;
                case 3:
                    lihatDaftarSaham();
                    break;
                case 4:
                    hapusSaham();
                    break;
                case 5:
                    isSahamMenuActive = false;
                    break;
            }
        }
    }

    private void tambahSaham() {
        ClearScreen.clear();
        tambahSahamMenu();

        System.out.print("Kode Saham: ");
        String kode = InputUtil.getStringInput();

        System.out.print("Nama Perusahaan: ");
        String nama = InputUtil.getStringInput();

        System.out.print("Harga Saham: ");
        double harga = InputUtil.getDoubleInput();

        Saham sahamBaru = new Saham(kode, nama, harga);
        dataStorage.tambahSaham(sahamBaru);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Saham berhasil ditambahkan!");
        InputUtil.pressEnterToContinue();
    }

    private void ubahHargaSaham() {
        ClearScreen.clear();
        ubahHargaSahamMenu();

        List<Saham> daftarSaham = dataStorage.getDaftarSaham();
        if (daftarSaham.isEmpty()) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Belum ada saham yang terdaftar.");
            InputUtil.pressEnterToContinue();
            return;
        }

        System.out.println("---------------------------------------------------------------------");
        System.out.println("Daftar Saham:");
        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarSaham.get(i));
        }

        System.out.print("Pilih saham (nomor): ");
        int pilihan = InputUtil.getIntInput(1, daftarSaham.size());

        System.out.print("Harga baru: ");
        double hargaBaru = InputUtil.getDoubleInput();

        Saham saham = daftarSaham.get(pilihan - 1);
        saham.setHarga(hargaBaru);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Harga saham berhasil diubah!");
        InputUtil.pressEnterToContinue();
    }

    private void lihatDaftarSaham() {
        ClearScreen.clear();
        listSahamView();
        List<Saham> daftarSaham = dataStorage.getDaftarSaham();

        if (daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham yang terdaftar.");
        } else {
            for (int i = 0; i < daftarSaham.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, daftarSaham.get(i));
            }
        }
        System.out.println("---------------------------------------------------------------------");
        InputUtil.pressEnterToContinue();
    }

    private void hapusSaham() {
        ClearScreen.clear();
        deleteSaham();
        List<Saham> daftarSaham = dataStorage.getDaftarSaham();

        if (daftarSaham.isEmpty()) {
            System.out.println("Belum ada saham yang bisa dihapus.");
            InputUtil.pressEnterToContinue();
            return;
        }

        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarSaham.get(i));
        }

        System.out.print("Pilih saham yang akan dihapus (nomor): ");
        int pilihan = InputUtil.getIntInput(1, daftarSaham.size());

        Saham saham = daftarSaham.get(pilihan - 1);
        dataStorage.hapusSaham(saham);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Saham berhasil dihapus.");
        InputUtil.pressEnterToContinue();
    }

    private void kelolaSBN() {
        boolean isSBNMenuActive = true;

        while (isSBNMenuActive) {
            ClearScreen.clear();
            adminSbnMenu();
            int choice = InputUtil.getIntInput(1, 4);

            switch (choice) {
                case 1:
                    tambahSBN();
                    break;
                case 2:
                    lihatDaftarSBN();
                    break;
                case 3:
                    hapusSBN();
                    break;
                case 4:
                    isSBNMenuActive = false;
                    break;
            }
        }
    }

    private void tambahSBN() {
        ClearScreen.clear();
        tambahSbnMenu();

        System.out.print("Nama SBN: ");
        String nama = InputUtil.getStringInput();

        System.out.print("Bunga (% per tahun): ");
        double bunga = InputUtil.getDoubleInput();

        System.out.print("Jangka Waktu (bulan): ");
        int jangkaWaktu = InputUtil.getIntInput(1, 120);

        System.out.print("Tanggal Jatuh Tempo (YYYY-MM-DD): ");
        LocalDate jatuhTempo = LocalDate.parse(InputUtil.getStringInput());

        System.out.print("Kuota Nasional: ");
        double kuota = InputUtil.getDoubleInput();

        SBN sbnBaru = new SBN(nama, bunga, jangkaWaktu, jatuhTempo, kuota);
        dataStorage.tambahSBN(sbnBaru);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("SBN berhasil ditambahkan!");
        InputUtil.pressEnterToContinue();
    }

    private void lihatDaftarSBN() {
        ClearScreen.clear();
        listSbnView();
        List<SBN> daftarSbn = dataStorage.getDaftarSBN();

        if (daftarSbn.isEmpty()) {
            System.out.println("Belum ada SBN yang terdaftar.");
        } else {
            for (int i = 0; i < daftarSbn.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, daftarSbn.get(i));
            }
        }
        System.out.println("---------------------------------------------------------------------");
        InputUtil.pressEnterToContinue();
    }

    private void hapusSBN() {
        ClearScreen.clear();
        deleteSBN();
        List<SBN> daftarSbn = dataStorage.getDaftarSBN();

        if (daftarSbn.isEmpty()) {
            System.out.println("Belum ada SBN yang bisa dihapus.");
            InputUtil.pressEnterToContinue();
            return;
        }

        for (int i = 0; i < daftarSbn.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarSbn.get(i));
        }

        System.out.print("Pilih SBN yang akan dihapus (nomor): ");
        int pilihan = InputUtil.getIntInput(1, daftarSbn.size());

        SBN sbn = daftarSbn.get(pilihan - 1);
        dataStorage.hapusSBN(sbn);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("SBN berhasil dihapus.");
        InputUtil.pressEnterToContinue();
    }

    @Override
    public List<Saham> getDaftarSaham() {
        return dataStorage.getDaftarSaham();
    }

    @Override
    public List<SBN> getDaftarSBN() {
        return dataStorage.getDaftarSBN();
    }
}