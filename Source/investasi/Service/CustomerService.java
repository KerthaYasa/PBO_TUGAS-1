package investasi.Service;

import investasi.Model.Portofolio;
import investasi.Model.Saham;
import investasi.Model.SBN;
import investasi.Util.ClearScreen;
import investasi.Util.DataStorage;
import investasi.Util.InputUtil;
import java.util.List;
import java.util.Map;

import static investasi.Util.InputUtil.getDoubleInput;
import static investasi.View.CustomerView.*;

public class CustomerService implements InvestasiService {
    private Portofolio portofolio = new Portofolio();
    private DataStorage dataStorage = DataStorage.getInstance();

    public void showCustomerMenu() {
        boolean isCustomerActive = true;

        while (isCustomerActive) {
            customerMenu();
            int choice = InputUtil.getIntInput(1, 6);

            switch (choice) {
                case 1:
                    beliSaham();
                    break;
                case 2:
                    jualSaham();
                    break;
                case 3:
                    beliSBN();
                    break;
                case 4:
                    simulasiSBN();
                    break;
                case 5:
                    lihatPortofolio();
                    break;
                case 6:
                    isCustomerActive = false;
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("Logout berhasil!");
                    break;
            }
        }
    }

    private void beliSaham() {
        customerBeliSahamMenu();
        List<Saham> daftarSaham = dataStorage.getDaftarSaham();

        if (daftarSaham.isEmpty()) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Belum ada saham yang tersedia.");
            InputUtil.pressEnterToContinue();
            return;
        }

        System.out.println("Daftar Saham Tersedia:");
        for (int i = 0; i < daftarSaham.size(); i++) {
            System.out.printf("%d. %s\n", i+1, daftarSaham.get(i));
        }

        System.out.print("Pilih saham (nomor): ");
        int pilihan = InputUtil.getIntInput(1, daftarSaham.size());

        System.out.print("Jumlah lembar: ");
        int jumlah = InputUtil.getIntInput(1, Integer.MAX_VALUE);

        Saham sahamDipilih = daftarSaham.get(pilihan - 1);
        portofolio.tambahSaham(sahamDipilih, jumlah);

        double totalHarga = sahamDipilih.getHarga() * jumlah;
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("Pembelian berhasil! Total: Rp%,.2f\n", totalHarga);
        InputUtil.pressEnterToContinue();
    }

    private void jualSaham() {
        ClearScreen.clear();
        customerJualSahamMenu();

        Map<Saham, Integer> sahamDimiliki = portofolio.getSahamDimiliki();
        if (sahamDimiliki.isEmpty()) {
            System.out.println("Anda belum memiliki saham.");
            InputUtil.pressEnterToContinue();
            return;
        }

        // Tampilkan saham yang dimiliki
        System.out.println("Daftar Saham Anda:");
        int index = 1;
        Saham[] sahamArray = sahamDimiliki.keySet().toArray(new Saham[0]);
        for (Saham saham : sahamArray) {
            int jumlah = sahamDimiliki.get(saham);
            double nilai = saham.getHarga() * jumlah;
            System.out.printf("%d. %s (%,d lembar) - Nilai: Rp%,.2f\n",
                    index++, saham, jumlah, nilai);
        }

        System.out.print("Pilih saham (nomor): ");
        int pilihan = InputUtil.getIntInput(1, sahamArray.length);

        Saham sahamDipilih = sahamArray[pilihan - 1];
        int jumlahDimiliki = sahamDimiliki.get(sahamDipilih);

        System.out.printf("Jumlah lembar yang dimiliki: %,d\n", jumlahDimiliki);
        System.out.print("Jumlah lembar yang akan dijual: ");
        int jumlahJual = InputUtil.getIntInput(1, jumlahDimiliki);

        portofolio.kurangiSaham(sahamDipilih, jumlahJual);
        double totalHarga = sahamDipilih.getHarga() * jumlahJual;
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("Penjualan berhasil! Total: Rp%,.2f\n", totalHarga);
        InputUtil.pressEnterToContinue();
    }

    private void beliSBN() {
        ClearScreen.clear();
        customerBeliSbnMenu();

        List<SBN> daftarSBN = dataStorage.getDaftarSBN();
        if (daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN yang tersedia.");
            InputUtil.pressEnterToContinue();
            return;
        }

        System.out.println("Daftar SBN Tersedia:");
        for (int i = 0; i < daftarSBN.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarSBN.get(i));
        }

        System.out.print("Pilih SBN (nomor): ");
        int pilihan = InputUtil.getIntInput(1, daftarSBN.size());

        SBN sbnDipilih = daftarSBN.get(pilihan - 1);

        System.out.println("---------------------------------------------------------------------");
        System.out.printf("Kuota tersedia: Rp%,.2f\n", sbnDipilih.getKuotaNasional());
        System.out.print("Nominal pembelian: ");
        double nominal = getDoubleInput();

        if (nominal > sbnDipilih.getKuotaNasional()) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Nominal melebihi kuota nasional!");
        } else {
            portofolio.tambahSBN(sbnDipilih, nominal);
            sbnDipilih.setKuotaNasional(sbnDipilih.getKuotaNasional() - nominal);
            System.out.println("---------------------------------------------------------------------");
            System.out.printf("Pembelian SBN berhasil! Nominal: Rp%,.2f\n", nominal);
        }

        InputUtil.pressEnterToContinue();
    }

    private void simulasiSBN() {
        ClearScreen.clear();
        customerSimulasiSbnMenu();

        List<SBN> daftarSBN = dataStorage.getDaftarSBN();
        if (daftarSBN.isEmpty()) {
            System.out.println("Belum ada SBN yang tersedia.");
            InputUtil.pressEnterToContinue();
            return;
        }

        // Tampilkan daftar SBN
        System.out.println("Daftar SBN Tersedia:");
        for (int i = 0; i < daftarSBN.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarSBN.get(i));
        }

        System.out.print("Pilih SBN (nomor): ");
        int pilihan = InputUtil.getIntInput(1, daftarSBN.size());

        SBN sbnDipilih = daftarSBN.get(pilihan - 1);

        System.out.print("Nominal investasi: ");
        double nominal = getDoubleInput();

        // Hitung bunga per bulan: %bunga / 12 bulan * 90% * nominal investasi
        double bungaPerBulan = (sbnDipilih.getBunga() / 100 / 12) * 0.9 * nominal;

        System.out.println("-----------------------    HASIL SIMULASI    ------------------------");
        System.out.printf("Nama SBN: %s\n", sbnDipilih.getNama());
        System.out.printf("Nominal Investasi: Rp%,.2f\n", nominal);
        System.out.printf("Bunga per Tahun: %.2f%%\n", sbnDipilih.getBunga());
        System.out.printf("Bunga per Bulan: Rp%,.2f\n", bungaPerBulan);
        System.out.printf("Jangka Waktu: %d bulan\n", sbnDipilih.getJangkaWaktu());
        System.out.printf("Total Bunga: Rp%,.2f\n", bungaPerBulan * sbnDipilih.getJangkaWaktu());
        System.out.println("---------------------------------------------------------------------");

        InputUtil.pressEnterToContinue();
    }

    private void lihatPortofolio() {
        ClearScreen.clear();
        customerPortofolioMenu();

        Map<Saham, Integer> sahamDimiliki = portofolio.getSahamDimiliki();
        Map<SBN, Double> sbnDimiliki = portofolio.getSbnDimiliki();

        System.out.println("----------------------------    SAHAM    ----------------------------");
        if (sahamDimiliki.isEmpty()) {
            System.out.println("Anda belum memiliki saham.");
        } else {
            double totalNilaiPasar = 0;
            double totalPembelian = 0;

            for (Map.Entry<Saham, Integer> entry : sahamDimiliki.entrySet()) {
                Saham saham = entry.getKey();
                int jumlah = entry.getValue();
                double nilaiPasar = saham.getHarga() * jumlah;
                totalNilaiPasar += nilaiPasar;
                totalPembelian += nilaiPasar; // Asumsi harga beli = harga sekarang

                System.out.printf("%s - %,d lembar - Nilai Pasar: Rp%,.2f\n",
                        saham, jumlah, nilaiPasar);
            }

            System.out.println("\nTotal Nilai Pasar Saham: Rp" + String.format("%,.2f", totalNilaiPasar));
            System.out.println("Total Pembelian Saham: Rp" + String.format("%,.2f", totalPembelian));
        }

        System.out.println("-----------------------------    SBN    -----------------------------");
        if (sbnDimiliki.isEmpty()) {
            System.out.println("Anda belum memiliki SBN.");
        } else {
            double totalBungaBulanan = 0;

            for (Map.Entry<SBN, Double> entry : sbnDimiliki.entrySet()) {
                SBN sbn = entry.getKey();
                double nominal = entry.getValue();
                double bungaBulanan = (sbn.getBunga() / 100 / 12) * 0.9 * nominal;
                totalBungaBulanan += bungaBulanan;

                System.out.printf("%s - Nominal: Rp%,.2f - Bunga/Bulan: Rp%,.2f\n",
                        sbn.getNama(), nominal, bungaBulanan);
            }

            System.out.println("\nTotal Bunga Bulanan: Rp" + String.format("%,.2f", totalBungaBulanan));
            System.out.println("---------------------------------------------------------------------");
        }

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